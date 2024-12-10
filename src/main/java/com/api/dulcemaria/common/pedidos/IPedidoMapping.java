package com.api.dulcemaria.common.pedidos;

import com.api.dulcemaria.contracts.pedidos.CreateDetallePedidoRequest;
import com.api.dulcemaria.contracts.pedidos.CreatePedidoRequest;
import com.api.dulcemaria.contracts.pedidos.UpdatePedidoRequest;
import com.api.dulcemaria.models.DetallePedido;
import com.api.dulcemaria.models.Pedido;


public interface IPedidoMapping {

    Pedido convertToPedido(CreatePedidoRequest request);
    DetallePedido convertToDetallePedido(CreateDetallePedidoRequest request);
    Pedido convertToPedido(UpdatePedidoRequest request);
}
