package com.api.dulcemaria.helpers.clientes;

import com.api.dulcemaria.contracts.clientes.CreateClienteRequest;
import com.api.dulcemaria.contracts.clientes.DireccionClienteRequest;
import com.api.dulcemaria.contracts.clientes.GetClienteResponse;
import com.api.dulcemaria.contracts.clientes.GetDireccionResponse;
import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.models.DireccionCliente;
import com.api.dulcemaria.models.Ubigeo;
import com.api.dulcemaria.repositories.IUbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapping implements IClienteMapping{

    @Autowired
    private IUbigeoRepository _ubigeoRepository;

    @Override
    public Cliente convertToCliente(CreateClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setTipoDocumento(request.tipoDocumento());
        cliente.setNumeroDocumento(request.numeroDocumento());
        cliente.setRazonSocialNombre(request.razonSocial());
        cliente.setContacto(request.contacto());
        cliente.setTelefono(request.telefono());
        cliente.setPaginaWeb(request.paginaWeb());
        cliente.setCorreo(request.correo());

        for (DireccionClienteRequest direccionClienteRequest : request.direccionClientes())
        {
            cliente.getDireccionClientes().add(convertToDireccionCliente(direccionClienteRequest, cliente));
        }

        return cliente;
    }

    @Override
    public DireccionCliente convertToDireccionCliente(DireccionClienteRequest request, Cliente cliente) {
        DireccionCliente direccionCliente = new DireccionCliente();

        Ubigeo ubigeo = _ubigeoRepository.findById(request.idUbigeo())
                .orElseThrow(() -> new RuntimeException("No se encontro el ubigeo con ID:" + request.idUbigeo()));

        direccionCliente.setDireccion(request.direccion());
        direccionCliente.setReferencia(request.referencia());
        direccionCliente.setUbigeo(ubigeo);
        direccionCliente.setCliente(cliente);

        return direccionCliente;
    }

    @Override
    public GetClienteResponse convertToGetClienteReponse(Cliente cliente) {

        return new GetClienteResponse(
                cliente.getId(),
                cliente.getRazonSocialNombre(),
                cliente.getNumeroDocumento(),
                cliente.getContacto(),
                cliente.getTelefono(),
                cliente.getCorreo(),
                cliente.getDireccionClientes().stream().map(this::convertToGetDireccionResponse).toList()
        );
    }

    @Override
    public GetDireccionResponse convertToGetDireccionResponse(DireccionCliente direccionCliente) {

        return new GetDireccionResponse(
                direccionCliente.getId(),
                direccionCliente.getDireccion(),
                direccionCliente.getUbigeo().getDistrito(),
                direccionCliente.getReferencia()
        );
    }

}
