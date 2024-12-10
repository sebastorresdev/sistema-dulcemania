package com.api.dulcemaria.contracts.pedidos;

import java.math.BigDecimal;

public record GetDetallePedidoResponse(
    int idProducto,
    String nombreProducto,
    int cantidad,
    BigDecimal precio
) {
}
