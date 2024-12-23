package com.api.dulcemaria.contracts.pedidos;

import java.util.List;

public record CreatePedidoRequest(
        int idDireccion,
        int idMedioPago,
        String observacion,
        String idUsuario,
        String tipoDocumento,
        List<CreateDetallePedidoRequest> detallePedidos
) {
}
