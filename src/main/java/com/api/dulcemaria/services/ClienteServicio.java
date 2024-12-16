package com.api.dulcemaria.services;

import java.util.List;

import com.api.dulcemaria.contracts.clientes.GetClienteResponse;
import com.api.dulcemaria.helpers.clientes.IClienteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dulcemaria.contracts.clientes.CreateClienteRequest;
import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.repositories.IClienteRepository;
import com.api.dulcemaria.repositories.IDireccionClienteRepository;

@Service
public class ClienteServicio {

    @Autowired 
    IClienteRepository _clienteRepository;
    @Autowired
    IDireccionClienteRepository _direccionClienteRepository;
    @Autowired
    IClienteMapping _mapping;

    public List<GetClienteResponse> listarClientes() {
        return  _clienteRepository.findAll()
                .stream()
                .map(c -> _mapping.convertToGetClienteReponse(c))
                .toList();
    }

    public GetClienteResponse guardarCliente(CreateClienteRequest clienteRequest) {

        Cliente cliente = _mapping.convertToCliente(clienteRequest);

        return _mapping.convertToGetClienteReponse(_clienteRepository.save(cliente));
    }
}