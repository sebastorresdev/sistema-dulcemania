package com.api.dulcemaria.contracts.pedidos;

import java.math.BigDecimal;
import java.util.List;

public record UpdatePedidoRequest(
        int id,
        int idDocumento,
        int idDireccion,
        int idMedioPago,
        String observacion,
        String tipoDocumento,
        List<CreateDetallePedidoRequest> detallePedidos
) {
}
