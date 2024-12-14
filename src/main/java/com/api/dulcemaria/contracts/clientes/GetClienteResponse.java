package com.api.dulcemaria.contracts.clientes;

import java.util.List;

public record GetClienteResponse(
        int id,
        String razonSocial,
        String ruc,
        String personaContacto,
        String telefono,
        String correo,
        List<GetDireccionResponse> direcciones
) {
}
