package com.api.dulcemaria.common.pedidos;

import java.math.BigDecimal;

public record DetailsPedidos(
        int idProducto,
        int cantidad,
        BigDecimal precioUnitario,
        BigDecimal descuento
) {
}
