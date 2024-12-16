package com.api.dulcemaria.contracts.usuarios;

public record CreateUsuarioRequest(
        String nombreCompleto,
        String email,
        String identificador
) {
}
