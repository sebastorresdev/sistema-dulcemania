package com.api.dulcemaria.contracts.proveedores;

import java.util.List;

public record CreateProveedorRequest(
		String ruc,
		String razonSocial,
		String contacto,
		String telefono1,
		String telefono2,
		String direccion,
		String correo,
		String idUbigeo,
		String observacionDireccion
) {
}
