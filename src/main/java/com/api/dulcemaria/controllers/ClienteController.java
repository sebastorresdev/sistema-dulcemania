package com.api.dulcemaria.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.services.ClienteService;

@RestController
@RequestMapping ("/api/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService cliser;
	
	@GetMapping()
	public List<Cliente> listarclientes(){
		return cliser.listarclientes();
	}
	
	@PostMapping()
	public Cliente guardarclientes(@RequestBody Cliente c) {
		return cliser.guardarclientes(c);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarcliente (@PathVariable Integer id) {
		boolean res= cliser.eliminarcliente(id);
		if (res)
			return "Elimino el registro con el Codigo = " + id;
		else
			return "No se puede elimar al cliente";
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarCliente(@PathVariable Integer id, @RequestBody Cliente cliente) {
	    cliente.setId(id);
	    Cliente clienteActualizado = cliser.actualizarCliente(cliente);

	    if (clienteActualizado == null) {
	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok().body(
	        Map.of(
	            "mensaje", "Cliente actualizado correctamente",
	            "cliente", clienteActualizado
	        )
	    );
	}
	
	@GetMapping("/{numeroDocumento}")
	public Optional<Cliente> buscarnumeroDocumento(@PathVariable String numeroDocumento){
		return cliser.buscarnumeroDocumento(numeroDocumento);
	}
}
