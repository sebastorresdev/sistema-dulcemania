package com.api.dulcemaria.common.proveedores;

import com.api.dulcemaria.contracts.proveedores.CreateProveedorRequest;
import com.api.dulcemaria.models.Proveedor;
import com.api.dulcemaria.models.Ubigeo;
import com.api.dulcemaria.repositories.IUbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProveedorMapping implements IProveedorMapping {

    @Autowired
    IUbigeoRepository _UbigeoRepository;

    @Override
    public Proveedor convertToProveedor(CreateProveedorRequest proveedorRequest) {
        Proveedor proveedor = new Proveedor();

        Ubigeo ubigeo = _UbigeoRepository.findById(proveedorRequest.idUbigeo())
                .orElseThrow(() -> new RuntimeException("No se encontro el ubigeo con ID: " + proveedorRequest.idUbigeo()));

        proveedor.setUbigeo(ubigeo);
        proveedor.setContacto(proveedorRequest.contacto());
        proveedor.setCorreo(proveedorRequest.correo());
        proveedor.setDireccion(proveedorRequest.direccion());
        proveedor.setObservacionDireccion(proveedorRequest.observacionDireccion());
        proveedor.setRazonSocial(proveedorRequest.razonSocial());
        proveedor.setRuc(proveedorRequest.ruc());
        proveedor.setTelefono1(proveedorRequest.telefono1());
        proveedor.setTelefono2(proveedorRequest.telefono2());

        return proveedor;
    }
}
