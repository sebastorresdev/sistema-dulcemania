package com.api.dulcemaria.contracts.clientes;

public record GetDireccionResponse(
        int id,
        String direccion,
        String distrito,
        String referencia
) {
}
