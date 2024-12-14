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


