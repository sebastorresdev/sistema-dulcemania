package com.api.dulcemaria.controllers;

import com.api.dulcemaria.models.UnidadMedida;
import com.api.dulcemaria.services.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("api/medidas")
public class UnidadMedidaController {
	@Autowired
	UnidadMedidaService medidas;
	
	@GetMapping()
	public List<UnidadMedida> listarmedidas(){
		return medidas.listarmedidas();
	}
	
	@GetMapping("/{nombre}")
	public Optional<UnidadMedida> buscarnombre(@PathVariable String nombre){
		return medidas.buscarnombre(nombre);
	}

}
