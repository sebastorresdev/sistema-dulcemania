package com.api.dulcemaria.controllers;

import com.api.dulcemaria.contracts.proveedores.CreateProveedorRequest;
import com.api.dulcemaria.models.Proveedor;
import com.api.dulcemaria.services.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping ("/api/proveedores")
public class ProveedorController {
	@Autowired
	ProveedorServicio proser;
	
	@GetMapping()
	public List<Proveedor> listarProveedores(){
		return proser.listarProveedores();
	}
	
	@PostMapping
	public ResponseEntity<Proveedor> guardarProveedorYDetalles(@RequestBody CreateProveedorRequest request) {
		return new ResponseEntity<>(proser.guardarProveedor(request), HttpStatus.OK);
	}

	}
	
	/*@DeleteMapping("/{id}")
	public String eliminarproveedor (@PathVariable Integer id) {
		boolean res= proser.eliminarproveedor(id);
		if (res)
			return "Elimino el registro con el Codigo = " + id;
		else
			return "No se puede elimar al proveedor";
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> actualizarProveedor(@PathVariable Integer id, @RequestBody Proveedor proveedor) {
	    proveedor.setId(id);
	    
	    Proveedor proveedorActualizado = proser.actualizarProveedor(proveedor);

	    if (proveedorActualizado == null) {
	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok().body(
	        Map.of(
	            "mensaje", "Proveedor actualizado correctamente",
	            "proveedor", proveedorActualizado
	        )
	    );
	}
	
	@GetMapping("/{ruc}")
	public Optional<Proveedor> buscarruc(@PathVariable String ruc){
		return proser.buscarruc(ruc);
	}*/
	
		

