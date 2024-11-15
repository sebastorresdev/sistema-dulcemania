package com.api.dulcemaria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.dulcemaria.models.MedioPago;
import com.api.dulcemaria.services.MedioPagoService;

@Controller
@RequestMapping ("/api/pagos")
public class MedioPagoController {
	@Autowired
	MedioPagoService mediser;
	
	@GetMapping
	public ResponseEntity< List<MedioPago>> listarpagos(){
		return ResponseEntity.ok(mediser.listarpagos());
	}
	
	@PostMapping
	public MedioPago guardarpago(@RequestBody MedioPago m) {
		return mediser.guardarpago(m);
	}
	
	@GetMapping("/{descripcion}")
	public Optional<MedioPago> BuscarPorDescripcion(@PathVariable String descripcion){
		return mediser.BuscarPorDescripcion(descripcion);
	}
	

}