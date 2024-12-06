package com.api.dulcemaria.controllers;

import com.api.dulcemaria.models.Compra;
import com.api.dulcemaria.services.CompraService;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/api/compras")
public class CompraController {
	@Autowired
	CompraService comser;
	
	@GetMapping()
	public List<Compra> listarcompras(){
		return comser.listarcompras();
	}
	
	@GetMapping("/{tipoDocumento}")
	public Optional<Compra> tipoDocumento(@PathVariable String tipoDocumento){
		return comser.tipoDocumento(tipoDocumento);
	}
	
	@PostMapping()
    public ResponseEntity<?> guardarCompra(@RequestBody Compra c) {
        try {
           
            Compra compraGuardada = comser.guardarcompra(c);            
            return ResponseEntity.status(HttpStatus.CREATED).body(compraGuardada);
        } catch (NonUniqueResultException e) {           
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: La compra ya existe.");
        } catch (Exception e) {     
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor.");
        }
    }
	
	@DeleteMapping("/{id}")
	public String eliminarcompra (@PathVariable Integer id) {
		boolean res= comser.eliminarcompra(id);
		if (res)
			return "Elimino el registro con el Codigo = " + id;
		else
			return "No se puede elimar la compra";
	}
	
		
}
