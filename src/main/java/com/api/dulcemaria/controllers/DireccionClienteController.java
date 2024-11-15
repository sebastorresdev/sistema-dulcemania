package com.api.dulcemaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dulcemaria.models.DireccionCliente;
import com.api.dulcemaria.services.DireccionClienteService;


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
