package com.api.dulcemaria.controllers;

import com.api.dulcemaria.models.Proveedor;
import com.api.dulcemaria.services.ProveedorServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping ("/api/proveedores")
public class ProveedorController {
	@Autowired
	ProveedorServicio proser;
	
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
