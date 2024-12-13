package com.api.dulcemaria.controllers;

import java.util.List;

import com.api.dulcemaria.contracts.pedidos.CreatePedidoRequest;
import com.api.dulcemaria.contracts.pedidos.GetPedidoResponse;
import com.api.dulcemaria.contracts.pedidos.UpdatePedidoRequest;
import com.api.dulcemaria.services.ProductoService;
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

	@Autowired
	ProductoService _productorService;
	
	@GetMapping
	public ResponseEntity< List<GetPedidoResponse>> listarPedido(){
		return ResponseEntity.ok(_pedidoService.listarPedido());
	}

	@PostMapping
	public ResponseEntity<GetPedidoResponse> guardarPedido(@RequestBody CreatePedidoRequest request) {

		GetPedidoResponse response = _pedidoService.guardarPedido(request);

		_productorService.actualizarStock(response.detallePedidos());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<GetPedidoResponse> editarPedido(@RequestBody UpdatePedidoRequest request) {

		GetPedidoResponse response = _pedidoService.editarPedido(request);

		_productorService.actualizarStock(response.detallePedidos());

		return new ResponseEntity<>(_pedidoService.editarPedido(request), HttpStatus.OK);
	}
}
