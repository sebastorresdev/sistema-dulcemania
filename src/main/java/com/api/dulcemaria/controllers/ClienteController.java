package com.api.dulcemaria.controllers;

import com.api.dulcemaria.contracts.clientes.CreateClienteRequest;
import com.api.dulcemaria.contracts.clientes.GetClienteResponse;
import com.api.dulcemaria.models.Cliente;
import com.api.dulcemaria.services.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/clientes")
public class ClienteController {
	
	@Autowired
	ClienteServicio _clienteService;
	
	@GetMapping()
	public List<GetClienteResponse> listarclientes(){
		return _clienteService.listarClientes();
	}

	@PostMapping
	public ResponseEntity<GetClienteResponse> guardarCliente(@RequestBody CreateClienteRequest request) {
		return new ResponseEntity<>(_clienteService.guardarCliente(request), HttpStatus.OK);
	}
	
	/*@DeleteMapping("/{id}")
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
	}*/
}
