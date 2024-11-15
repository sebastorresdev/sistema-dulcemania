package com.api.dulcemaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.api.dulcemaria.models.Moneda;
import com.api.dulcemaria.services.MonedaService;

@Controller
@RequestMapping ("/api/monedas")
public class MonedaController {
    @Autowired
	MonedaService moneser;

    @GetMapping
	public ResponseEntity< List<Moneda>> listarmoneda(){
		return ResponseEntity.ok(moneser.listarmoneda());
	}

}
