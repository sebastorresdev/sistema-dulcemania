package com.api.dulcemaria.helpers.clientes;

import com.api.dulcemaria.contracts.clientes.CreateClienteRequest;
import com.api.dulcemaria.contracts.clientes.DireccionClienteRequest;
import com.api.dulcemaria.contracts.clientes.GetClienteResponse;
import com.api.dulcemaria.contracts.clientes.GetDireccionResponse;
import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.models.DireccionCliente;

public interface IClienteMapping {
    Cliente convertToCliente(CreateClienteRequest request);
    DireccionCliente convertToDireccionCliente(DireccionClienteRequest request, Cliente cliente);
    GetClienteResponse convertToGetClienteReponse(Cliente cliente);
    GetDireccionResponse convertToGetDireccionResponse(DireccionCliente direccionCliente);
}
