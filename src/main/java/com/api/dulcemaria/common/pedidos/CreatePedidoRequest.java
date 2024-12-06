package com.api.dulcemaria.common.pedidos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public record CreatePedidoRequest(
        Timestamp fecha,
        int idDocumento,
        BigDecimal total,
        int idDireccion,
        int idMedioPago,
        String observacion,
        List<DetailsPedidos> detailsPedidos
) {
}
