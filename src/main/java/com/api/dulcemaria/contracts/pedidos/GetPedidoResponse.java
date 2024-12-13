package com.api.dulcemaria.contracts.pedidos;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public record GetPedidoResponse(
        int id,
        Timestamp fecha,
        String estado,
        BigDecimal total,
        String nombreVendedor,
        String nombreCliente,
        String distrito,
        String direccion,
        String observacion,
        String tipoDocumento,
        String ruc,
        String medioPago,
        String numeroDocumento,
        List<GetDetallePedidoResponse> detallePedidos
) {
}
