package com.api.dulcemaria.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.api.dulcemaria.helpers.pedidos.IPedidoMapping;
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

	public List<GetPedidoResponse> listarPedido(String identificador){

		List<Pedido> pedidos = _pedidoRepository.findAll();

		List<Pedido> pedidosFiltrados = pedidos.stream()
				.filter(p -> p.getUsuario() != null && p.getUsuario().getIdentificador().equals(identificador))
				.collect(Collectors.toList());


		return pedidosFiltrados.stream().map(p -> _mapping.convertToGetPedidoResponse(p)).toList();
	}
	
	@Transactional
	public GetPedidoResponse guardarPedido(CreatePedidoRequest pedidoRequest) {

		Pedido pedido = _mapping.convertToPedido(pedidoRequest);

		return _mapping.convertToGetPedidoResponse(_pedidoRepository.save(pedido));
	}

	@Transactional
	public GetPedidoResponse editarPedido(UpdatePedidoRequest updatePedidoRequest) {

		Pedido nuevoPedido = _mapping.convertToPedido(updatePedidoRequest);

		Pedido pedidoExistente = _pedidoRepository.findById(nuevoPedido.getId())
				.orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con ID: " + nuevoPedido.getId()));

		pedidoExistente.setObservacion(nuevoPedido.getObservacion());
		pedidoExistente.setCliente(nuevoPedido.getCliente());
		pedidoExistente.setDocumento(nuevoPedido.getDocumento());
		pedidoExistente.setMedioPago(nuevoPedido.getMedioPago());
		pedidoExistente.setTotal(nuevoPedido.getTotal());
		pedidoExistente.setTipoDocumento(nuevoPedido.getTipoDocumento());

		pedidoExistente.getDetallePedidos().clear();

		for (DetallePedido detalle : nuevoPedido.getDetallePedidos()) {
			detalle.setPedido(nuevoPedido);
			pedidoExistente.getDetallePedidos().add(detalle);
		}
		return _mapping.convertToGetPedidoResponse(_pedidoRepository.save(pedidoExistente));
	}

	public void registrarVenta(String tipoDocumento) {
	}
}
