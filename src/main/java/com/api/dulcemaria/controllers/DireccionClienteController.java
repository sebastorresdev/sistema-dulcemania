package com.api.dulcemaria.controllers;

import com.api.dulcemaria.models.DireccionCliente;
import com.api.dulcemaria.services.DireccionClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/direccion")
public class DireccionClienteController {
	@Autowired
	DireccionClienteService dicli;
	
	@GetMapping()
	public List<DireccionCliente> listardireccion(){
		return dicli.listardireccion();
	}
	
	@PostMapping()
	public DireccionCliente guardardireccion(@RequestBody DireccionCliente p) {
		return dicli.guardardireccion(p);
	}
	
	
	
}
