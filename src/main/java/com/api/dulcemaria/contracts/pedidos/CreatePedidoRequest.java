package com.api.dulcemaria.contracts.pedidos;

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
        int idUsuario,
        List<CreateDetallePedidoRequest> detallePedidos
) {
}
