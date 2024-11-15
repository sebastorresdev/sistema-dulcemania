package com.api.dulcemaria.common.productos;

import java.math.BigDecimal;
import java.util.Optional;

public record UpdateProductoRequest(
        int id,
        String codigoInterno,
        String descripcion,
        int stockMinimo,
        int idFamilia,
        int idMarca,
        BigDecimal precioUnitario,
        Optional<String> codigoBarras,
        Optional<String> urlImg
) {
}
