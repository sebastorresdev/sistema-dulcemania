package com.api.dulcemaria.common.productos;

import java.math.BigDecimal;
import java.util.List;

public record GetProductoResponse(
    int id,
    String descripcion,
    String familia,
    String marca,
    boolean esActivo,
    BigDecimal precioUnitario,
    int stock,
    String urlImg,
    int stockMinimo
) {
}
