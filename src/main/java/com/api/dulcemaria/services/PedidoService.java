package com.api.dulcemaria.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.api.dulcemaria.common.pedidos.CreatePedidoRequest;
import com.api.dulcemaria.common.pedidos.DetailsPedidos;
import com.api.dulcemaria.models.*;
import com.api.dulcemaria.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PedidoService {
	@Autowired 
	IPedidoRepository iped;

	@Autowired
	IDetallePedidoRepository _detallePedidoRepository;

	@Autowired
	IDireccionClienteRepository _direccionClienteRespository;

	@Autowired
	IMedioPagoRepository _medioPagoRepository;

	@Autowired
	IEstadoDocumentoRepository _estadoDocumentoRepository;

	@Autowired
	IProductosRepository _productoRepository;

	public List<Pedido> listarpedido(){
		return (List<Pedido>)iped.findAll();
	}
	
	
	public Pedido guardarpedido(CreatePedidoRequest p) {

		DireccionCliente direccionCliente = _direccionClienteRespository.findById(p.idDireccion())
				.orElseThrow(() -> new RuntimeException("Direccion no encontrada con ID: " + p.idDireccion()));

		MedioPago medioPago = _medioPagoRepository.findById(p.idMedioPago())
				.orElseThrow(() -> new RuntimeException("Medio pago no encontrada con ID: " + p.idMedioPago()));

		EstadoDocumento estadoDocumento = _estadoDocumentoRepository.findById(p.idDocumento())
				.orElseThrow(() -> new RuntimeException("Documento no encontrada con ID: " + p.idDocumento()));

		Pedido pedido = new Pedido();
		pedido.setCliente(direccionCliente);
		pedido.setDocumento(estadoDocumento);
		pedido.setFecha(p.fecha());
		pedido.setTotal(p.total());
		pedido.setObservacion(p.observacion());
		pedido.setMedioPago(medioPago);

		return iped.save(pedido);

	}

	public Pedido guardarPedidoYDetalles(CreatePedidoRequest p) {
		Pedido pedido = this.guardarpedido(p);
		if (pedido == null ) return null;
		List<DetallePedido> detallesPedidos = new ArrayList<>();

		for (DetailsPedidos dp : p.detailsPedidos()) {
			DetallePedido detallePedido = new DetallePedido();

			detallePedido.setPedido(pedido);
			detallePedido.setCantidad(dp.cantidad());
			detallePedido.setDescuento(dp.descuento());

			Producto producto = _productoRepository.findById(dp.idProducto())
					.orElseThrow(() -> new RuntimeException("Producto no encontrada con ID: " + dp.idProducto()));

			detallePedido.setProducto(producto);
			detallePedido.setPrecioUnitario(dp.precioUnitario());

			BigDecimal subTotal = dp.precioUnitario().multiply(new BigDecimal(dp.cantidad())).subtract(dp.descuento());

			detallePedido.setSubtotal(subTotal);
			detallePedido.setFechaRegistro(pedido.getFecha());

			detallesPedidos.add(detallePedido);

		}
		_detallePedidoRepository.saveAll(detallesPedidos);
		return pedido;
	}

}
