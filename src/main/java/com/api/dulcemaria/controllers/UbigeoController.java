package com.api.dulcemaria.controllers;

import com.api.dulcemaria.models.Ubigeo;
import com.api.dulcemaria.services.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/api/ubigeo")
public class UbigeoController {
	
	@Autowired
	UbigeoService ubiser;
	
	@GetMapping()
	public List<Ubigeo> listarubigeo(){
		return ubiser.listarubigeo();
	}
}
