package com.api.dulcemaria.common.productos;

import java.math.BigDecimal;

public record CreateProductoRequest(
    String codigoInterno,
    String descripcion,
    int stockMinimo,
    int idFamilia,
    int idMarca,
    BigDecimal precioUnitario,
    String codigoBarras,
    String urlImg
) {
}
