package com.api.dulcemaria.common.proveedores;

import com.api.dulcemaria.contracts.proveedores.CreateProveedorRequest;
import com.api.dulcemaria.models.Proveedor;

public interface IProveedorMapping {
    Proveedor convertToProveedor(CreateProveedorRequest proveedorRequest);
}
