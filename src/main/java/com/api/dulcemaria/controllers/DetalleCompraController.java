package com.api.dulcemaria.controllers;

import com.api.dulcemaria.models.DetalleCompra;
import com.api.dulcemaria.services.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/detallecompra")
public class DetalleCompraController {
	@Autowired
	DetalleCompraService detallecom;
	
	@GetMapping()
	public List<DetalleCompra> listardetallecompra (){
		return detallecom.listardetallecompra();
	}
	
	@GetMapping("/{id}")
	public Optional<DetalleCompra> buscarid(@PathVariable int id){
		return detallecom.buscarid(id);
	}
	

}
