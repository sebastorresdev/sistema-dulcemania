package com.api.dulcemaria.controllers;

import java.util.List;

import com.api.dulcemaria.common.pedidos.CreatePedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.dulcemaria.models.MedioPago;
import com.api.dulcemaria.models.Pedido;
import com.api.dulcemaria.services.PedidoService;

@Controller
@RequestMapping ("api/pedidos")
public class PedidoController {
	@Autowired
	PedidoService peser;
	
	@GetMapping
	public ResponseEntity< List<Pedido>> listarpedido(){
		return ResponseEntity.ok(peser.listarpedido());
	}
	
	
	@PostMapping
	public ResponseEntity<Pedido> guardarpedido(@RequestBody CreatePedidoRequest p) {
		return new ResponseEntity<>(peser.guardarPedidoYDetalles(p), HttpStatus.OK);
	}

}
