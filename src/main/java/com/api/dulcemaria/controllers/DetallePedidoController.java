package com.api.dulcemaria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dulcemaria.models.DetallePedido;
import com.api.dulcemaria.services.DetallePedidoService;

@RestController
@RequestMapping ("/api/detallepedido")
public class DetallePedidoController {
	
	@Autowired
	DetallePedidoService pedidoService;
	
	@GetMapping()
	public List<DetallePedido> listarpedido(){
		return pedidoService.listarpedido();
	}

}
