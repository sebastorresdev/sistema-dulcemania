package com.api.dulcemaria.helpers.pedidos;

import com.api.dulcemaria.contracts.pedidos.*;
import com.api.dulcemaria.models.*;
import com.api.dulcemaria.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    IUsuarioRepository _usuarioRepository;

    @Override
    public Pedido convertToPedido(CreatePedidoRequest request) {
        DireccionCliente direccionCliente = _direccionClienteRepository.findById(request.idDireccion())
                .orElseThrow(() -> new RuntimeException("Direccion no encontrada con ID: " + request.idDireccion()));

        MedioPago medioPago = _medioPagoRepository.findById(request.idMedioPago())
                .orElseThrow(() -> new RuntimeException("Medio pago no encontrada con ID: " + request.idMedioPago()));

        EstadoDocumento estadoDocumento = _estadoDocumentoRepository.findById(1) /*buscar el documento con id : 1 q es estado pendiente*/
                .orElseThrow(() -> new RuntimeException("Documento no encontrada con ID: " + 1));

        Usuario usuario = _usuarioRepository.findById(request.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrada con ID: " + request.idUsuario()));

        Pedido pedido = new Pedido();
        pedido.setFecha(request.fecha());
        pedido.setUsuario(usuario);
        pedido.setDocumento(estadoDocumento);
        pedido.setTotal(request.total());
        pedido.setCliente(direccionCliente);
        pedido.setMedioPago(medioPago);
        pedido.setTipoDocumento(request.tipoDocumento());
        pedido.setObservacion(request.observacion());

        List<DetallePedido> detallePedido = request.detallePedidos().stream().map(dp -> convertToDetallePedido(dp, pedido)).toList();

        pedido.setDetallePedidos(detallePedido);

        return pedido;
    }

    @Override
    public DetallePedido convertToDetallePedido(CreateDetallePedidoRequest request, Pedido pedido) {
        Producto producto = _productoRepository.findById(request.idProducto())
                .orElseThrow(() -> new RuntimeException(("Producto no encontrado con ID:" + request.idProducto())));

        BigDecimal subTotal = request.precioUnitario().multiply(new BigDecimal(request.cantidad())).subtract(request.descuento());

        DetallePedido detallePedido = new DetallePedido();
        detallePedido.setPedido(pedido);
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

        Pedido pedido = new Pedido();
        pedido.setId(request.id());
        pedido.setTotal(request.total());
        pedido.setDocumento(estadoDocumento);
        pedido.setCliente(direccionCliente);
        pedido.setMedioPago(medioPago);
        pedido.setTipoDocumento(request.tipoDocumento());
        pedido.setObservacion(request.observacion());

        List<DetallePedido> detallePedido = request.detallePedidos().stream().map(dp -> convertToDetallePedido(dp, pedido)).toList();

        pedido.setDetallePedidos(detallePedido);

        return pedido;
    }

    @Override
    public GetPedidoResponse convertToGetPedidoResponse(Pedido pedido) {

        List<GetDetallePedidoResponse> getDetallePedidoResponses =  new ArrayList<>();

        for (var detallePedido : pedido.getDetallePedidos()) {
            getDetallePedidoResponses.add(convertToGetDetallePedidoResponse(detallePedido));
        }

        return new GetPedidoResponse(
                pedido.getId(),
                pedido.getFecha(),
                pedido.getDocumento().getNombre(),
                pedido.getTotal(),
                pedido.getUsuario().getNombreCompleto(),
                pedido.getCliente().getCliente().getRazonSocialNombre(),
                pedido.getCliente().getUbigeo().getDistrito(),
                pedido.getCliente().getDireccion(),
                pedido.getObservacion(),
                pedido.getTipoDocumento(),
                pedido.getCliente().getCliente().getNumeroDocumento(),
                pedido.getMedioPago().getDescripcion(),
                getDetallePedidoResponses
        );
    }

    @Override
    public GetDetallePedidoResponse convertToGetDetallePedidoResponse(DetallePedido detallePedido)  {
        return new GetDetallePedidoResponse(
                detallePedido.getProducto().getId(),
                detallePedido.getProducto().getDescripcion(),
                detallePedido.getCantidad(),
                detallePedido.getSubtotal()
        );
    }
}
