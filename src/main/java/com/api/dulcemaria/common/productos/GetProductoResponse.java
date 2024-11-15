package com.api.dulcemaria.common.productos;

import java.math.BigDecimal;

public record GetProductoResponse(
    int id,
    String descripcion,
    String familia,
    String marca,
    boolean esActivo,
    BigDecimal precioUnitario,
    int stock,
    String urlImg,
    int stockMinimo,
    String codigoInterno,
    String codigoBarras
) {
}
