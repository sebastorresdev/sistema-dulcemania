package com.api.dulcemaria.contracts.pedidos;

import java.math.BigDecimal;

public record CreateDetallePedidoRequest(
        int idProducto,
        int cantidad,
        BigDecimal precioUnitario,
        BigDecimal descuento
) {
}
