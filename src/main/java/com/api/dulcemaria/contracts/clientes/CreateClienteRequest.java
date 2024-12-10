package com.api.dulcemaria.contracts.clientes;

import java.util.List;

public record CreateClienteRequest(
		String tipoDocumento,
		String numeroDocumento,
		String razonSocial,
		String contacto,
		String telefono,
		String paginaWeb,
		String correo,
		List<DireccionClienteRequest> direccionClientes
) {
}
