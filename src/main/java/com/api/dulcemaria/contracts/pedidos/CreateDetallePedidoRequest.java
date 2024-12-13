package com.api.dulcemaria.contracts.pedidos;

public record CreateDetallePedidoRequest(
        int idProducto,
        int cantidad
) {
}