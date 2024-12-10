package com.api.dulcemaria.common.pedidos;

import com.api.dulcemaria.contracts.pedidos.CreateDetallePedidoRequest;
import com.api.dulcemaria.contracts.pedidos.CreatePedidoRequest;
import com.api.dulcemaria.contracts.pedidos.UpdatePedidoRequest;
import com.api.dulcemaria.models.*;
import com.api.dulcemaria.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PedidoMapping implements IPedidoMapping{

    @Autowired
    IDireccionClienteRepository _direccionClienteRepository;
    @Autowired
    IMedioPagoRepository _medioPagoRepository;
    @Autowired
    IEstadoDocumentoRepository _estadoDocumentoRepository;
    @Autowired
    IProductosRepository _productoRepository;

    @Override
    public Pedido convertToPedido(CreatePedidoRequest request) {

        DireccionCliente direccionCliente = _direccionClienteRepository.findById(request.idDireccion())
                .orElseThrow(() -> new RuntimeException("Direccion no encontrada con ID: " + request.idDireccion()));

        MedioPago medioPago = _medioPagoRepository.findById(request.idMedioPago())
                .orElseThrow(() -> new RuntimeException("Medio pago no encontrada con ID: " + request.idMedioPago()));

        EstadoDocumento estadoDocumento = _estadoDocumentoRepository.findById(request.idDocumento())
                .orElseThrow(() -> new RuntimeException("Documento no encontrada con ID: " + request.idDocumento()));

        List<DetallePedido> detallePedido = request.detallePedidos().stream().map(this::convertToDetallePedido).toList();


        Pedido pedido = new Pedido();
        pedido.setFecha(request.fecha());
        pedido.setDetallePedidos(detallePedido);
        pedido.setDocumento(estadoDocumento);
        pedido.setTotal(request.total());
        pedido.setCliente(direccionCliente);
        pedido.setMedioPago(medioPago);
        pedido.setObservacion(request.observacion());

        return pedido;
    }

    @Override
    public DetallePedido convertToDetallePedido(CreateDetallePedidoRequest request) {
        Producto producto = _productoRepository.findById(request.idProducto())
                .orElseThrow(() -> new RuntimeException(("Producto no encontrado con ID:" + request.idProducto())));

        BigDecimal subTotal = request.precioUnitario().multiply(new BigDecimal(request.cantidad())).subtract(request.descuento());

        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setCantidad(request.cantidad());
        detallePedido.setProducto(producto);
        detallePedido.setSubtotal(subTotal);
        detallePedido.setDescuento(request.descuento());
        detallePedido.setPrecioUnitario(request.precioUnitario());

        return detallePedido;
    }

    @Override
    public Pedido convertToPedido(UpdatePedidoRequest request) {
        DireccionCliente direccionCliente = _direccionClienteRepository.findById(request.idDireccion())
                .orElseThrow(() -> new RuntimeException("Direccion no encontrada con ID: " + request.idDireccion()));

        MedioPago medioPago = _medioPagoRepository.findById(request.idMedioPago())
                .orElseThrow(() -> new RuntimeException("Medio pago no encontrada con ID: " + request.idMedioPago()));

        EstadoDocumento estadoDocumento = _estadoDocumentoRepository.findById(request.idDocumento())
                .orElseThrow(() -> new RuntimeException("Documento no encontrada con ID: " + request.idDocumento()));

        List<DetallePedido> detallePedido = request.detallePedidos().stream().map(this::convertToDetallePedido).toList();

        Pedido pedido = new Pedido();
        pedido.setDetallePedidos(detallePedido);
        pedido.setId(request.id());
        pedido.setTotal(request.total());
        pedido.setDocumento(estadoDocumento);
        pedido.setCliente(direccionCliente);
        pedido.setMedioPago(medioPago);
        pedido.setObservacion(request.observacion());

        return pedido;
    }
}
