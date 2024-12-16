package com.api.dulcemaria.contracts.usuarios;

public record GetUsuarioResponse(
        String nombreCompleto,
        String email,
        String identificador
) {
}
