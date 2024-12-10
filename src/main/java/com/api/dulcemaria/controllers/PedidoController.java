package com.api.dulcemaria.controllers;

import java.util.List;

import com.api.dulcemaria.contracts.pedidos.CreatePedidoRequest;
import com.api.dulcemaria.contracts.pedidos.UpdatePedidoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.api.dulcemaria.models.Pedido;
import com.api.dulcemaria.services.PedidoService;

@Controller
@RequestMapping ("api/pedidos")
public class PedidoController {
	@Autowired
	PedidoService _pedidoService;
	
	@GetMapping
	public ResponseEntity< List<Pedido>> listarPedido(){
		return ResponseEntity.ok(_pedidoService.listarPedido());
	}

	@PostMapping
	public ResponseEntity<Pedido> guardarPedido(@RequestBody CreatePedidoRequest request) {
		return new ResponseEntity<>(_pedidoService.guardarPedido(request), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Pedido> editarPedido(@RequestBody UpdatePedidoRequest request) {
		return new ResponseEntity<>(_pedidoService.editarPedido(request), HttpStatus.OK);
	}
}
