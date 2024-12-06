package com.api.dulcemaria.services;

import com.api.dulcemaria.models.UnidadMedida;
import com.api.dulcemaria.repositories.IUnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnidadMedidaService {
	@Autowired
	IUnidadMedidaRepository medida;
	
	public List<UnidadMedida> listarmedidas(){
		return (List<UnidadMedida>)medida.findAll();
	}
	
	public Optional<UnidadMedida> buscarnombre(String nombre){
		return medida.findBynombre(nombre);
	}

	

}
