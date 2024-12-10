package com.api.dulcemaria.services;

import java.util.ArrayList;
import java.util.List;

import com.api.dulcemaria.common.clientes.IClienteMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dulcemaria.contracts.clientes.CreateClienteRequest;
import com.api.dulcemaria.contracts.clientes.DireccionClienteRequest;
import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.models.DireccionCliente;
import com.api.dulcemaria.models.Ubigeo;
import com.api.dulcemaria.repositories.IClienteRepository;
import com.api.dulcemaria.repositories.IDireccionClienteRepository;
import com.api.dulcemaria.repositories.IUbigeoRepository;

@Service
public class ClienteServicio {

    @Autowired 
    IClienteRepository _clienteRepository;
    @Autowired
    IDireccionClienteRepository _direccionClienteRepository;
    @Autowired
    IClienteMapping _mapping;

    public List<Cliente> listarClientes() {
        return (List<Cliente>) _clienteRepository.findAll();
    }

    public Cliente guardarCliente(CreateClienteRequest clienteRequest) {

        Cliente cliente = _mapping.convertToCliente(clienteRequest);

        return _clienteRepository.save(cliente);
    }
}

	
	/*public Cliente guardarclientes(Cliente c) {
		Optional<Cliente> reg=icli.findById(c.getId());
		if (!reg.isPresent()) 
			return icli.save(c);
		else
			return null;
		
	}
	
	public boolean eliminarcliente(Integer id) {
		Optional<Cliente> reg=icli.findById(id);
		if (reg.isPresent()) {
			icli.deleteById(id);
			return true;
		}
		else
			return false;
	}
	
	public Cliente actualizarCliente(Cliente c) {
	    Optional<Cliente> reg = icli.findById(c.getId());  
	    if (reg.isPresent()) {  
	        Cliente clienteExistente = reg.get();
	        
	        clienteExistente.setTipoDocumento(c.getTipoDocumento());
	        clienteExistente.setNumeroDocumento(c.getNumeroDocumento());
	        clienteExistente.setRazonSocialNombre(c.getRazonSocialNombre());
	        clienteExistente.setContacto(c.getContacto());
	        clienteExistente.setTelefono(c.getTelefono());
	        clienteExistente.setPaginaWeb(c.getPaginaWeb());
	        clienteExistente.setCorreo(c.getCorreo());
	        clienteExistente.setEsActivo(c.isEsActivo());
	        
	        return icli.save(clienteExistente);
	    } else {
	        
	        return null;
	    }
	}
	
	public Optional<Cliente> buscarnumeroDocumento(String numeroDocumento){
		return icli.findBynumeroDocumento(numeroDocumento);
	}
	
}*/


