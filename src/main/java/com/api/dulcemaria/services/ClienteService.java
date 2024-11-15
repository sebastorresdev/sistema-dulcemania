package com.api.dulcemaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.repositories.IClienteRepository;

@Service
public class ClienteService {
	@Autowired 
	IClienteRepository icli;
	
	
	public List<Cliente> listarclientes(){
		return (List<Cliente>)icli.findAll();
	}
	
	public Cliente guardarclientes(Cliente c) {
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
	
}
