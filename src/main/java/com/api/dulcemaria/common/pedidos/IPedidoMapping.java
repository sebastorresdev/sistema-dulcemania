package com.api.dulcemaria.common.pedidos;

import com.api.dulcemaria.contracts.pedidos.*;
import com.api.dulcemaria.models.DetallePedido;
import com.api.dulcemaria.models.Pedido;


public interface IPedidoMapping {

    Pedido convertToPedido(CreatePedidoRequest request);
    DetallePedido convertToDetallePedido(CreateDetallePedidoRequest request, Pedido pedido);
    Pedido convertToPedido(UpdatePedidoRequest request);

    GetPedidoResponse convertToGetPedidoResponse(Pedido pedido);
    GetDetallePedidoResponse convertToGetDetallePedidoResponse(DetallePedido detallePedido);
}
