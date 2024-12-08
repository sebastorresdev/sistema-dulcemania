package com.api.dulcemaria.services;

import java.util.ArrayList;
import java.util.List;

import com.api.dulcemaria.common.pedidos.IPedidoMapping;
import com.api.dulcemaria.contracts.pedidos.CreatePedidoRequest;
import com.api.dulcemaria.contracts.pedidos.GetPedidoResponse;
import com.api.dulcemaria.contracts.pedidos.UpdatePedidoRequest;
import com.api.dulcemaria.models.*;
import com.api.dulcemaria.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class PedidoService {

	@Autowired 
	IPedidoRepository _pedidoRepository;

	@Autowired
	IPedidoMapping _mapping;

	public List<GetPedidoResponse> listarPedido(){

		List<Pedido> pedidos = (List<Pedido>)_pedidoRepository.findAll();

		return pedidos.stream().map(p -> _mapping.convertToGetPedidoResponse(p)).toList();
	}
	
	@Transactional
	public Pedido guardarPedido(CreatePedidoRequest pedidoRequest) {

		Pedido pedido = _mapping.convertToPedido(pedidoRequest);

		return _pedidoRepository.save(pedido);
	}

	@Transactional
	public Pedido editarPedido(UpdatePedidoRequest updatePedidoRequest) {

		Pedido nuevoPedido = _mapping.convertToPedido(updatePedidoRequest);

		Pedido pedidoExistente = _pedidoRepository.findById(nuevoPedido.getId())
				.orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con ID: " + nuevoPedido.getId()));

		pedidoExistente.setObservacion(nuevoPedido.getObservacion());
		pedidoExistente.setCliente(nuevoPedido.getCliente());
		pedidoExistente.setDocumento(nuevoPedido.getDocumento());
		pedidoExistente.setMedioPago(nuevoPedido.getMedioPago());
		pedidoExistente.setTotal(nuevoPedido.getTotal());

		pedidoExistente.getDetallePedidos().clear();

		for (DetallePedido detalle : nuevoPedido.getDetallePedidos()) {
			detalle.setPedido(nuevoPedido);
			pedidoExistente.getDetallePedidos().add(detalle);
		}
		return _pedidoRepository.save(pedidoExistente);
	}
}
