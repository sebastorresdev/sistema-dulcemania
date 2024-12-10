package com.api.dulcemaria.contracts.productos;

import java.math.BigDecimal;

public record CreateProductoRequest(
    String codigoInterno,
    String descripcion,
    int stockMinimo,
    int idFamilia,
    int idMarca,
    int idUnidadMedida,
    BigDecimal precioUnitario,
    String codigoBarras,
    String urlImg
) {
}
