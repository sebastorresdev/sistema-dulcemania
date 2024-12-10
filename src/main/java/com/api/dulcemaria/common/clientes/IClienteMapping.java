package com.api.dulcemaria.common.clientes;

import com.api.dulcemaria.contracts.clientes.CreateClienteRequest;
import com.api.dulcemaria.contracts.clientes.DireccionClienteRequest;
import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.models.DireccionCliente;

public interface IClienteMapping {
    Cliente convertToCliente(CreateClienteRequest request);
    DireccionCliente convertToDireccionCliente(DireccionClienteRequest request, Cliente cliente);
}
