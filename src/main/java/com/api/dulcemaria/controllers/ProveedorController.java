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

import com.api.dulcemaria.models.Proveedor;
import com.api.dulcemaria.services.ProveedorService;


@RestController
@RequestMapping ("/api/proveedores")
public class ProveedorController {
	@Autowired
	ProveedorService proser;
	
	@GetMapping()
	public List<Proveedor> listarproveedores(){
		return proser.listarproveedores();
	}
	
	@PostMapping()
	public Proveedor guardarproveedor(@RequestBody Proveedor p) {
		return proser.guardarproveedor(p);
	}
	
	@DeleteMapping("/{id}")
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
	}
	
		
}
