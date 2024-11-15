package com.api.dulcemaria.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.api.dulcemaria.models.DireccionCliente;
import com.api.dulcemaria.repositories.IDireccionClienteRepository;


@Service
public class DireccionClienteService {
	@Autowired
	IDireccionClienteRepository idireccion; 
	
	
	public List<DireccionCliente> listardireccion(){
		return (List<DireccionCliente>)idireccion.findAll();
	}
	
	public DireccionCliente guardardireccion(DireccionCliente p) {
		Optional<DireccionCliente> reg=idireccion.findById(p.getId());
		if (!reg.isPresent()) 
			return idireccion.save(p);
		else
			return null;
		
	}
	
	

}