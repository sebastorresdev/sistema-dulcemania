package com.api.dulcemaria.controllers;

import com.api.dulcemaria.models.Venta;
import com.api.dulcemaria.services.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/ventas")
public class VentaController {
	@Autowired
	VentaService venser;
	
	@GetMapping()
	public List<Venta> listarventas(){
		return venser.listarventas();
	}
	
	@PostMapping()
	public Venta guardarventa(@RequestBody Venta v) {
		return venser.guardarventa(v);
	}
	
	@DeleteMapping("/{id}")
	public String eliminarventa (@PathVariable Integer id) {
		boolean res= venser.eliminarventa(id);
		if (res)
			return "Elimino el registro con el Codigo = " + id;
		else
			return "No se puede elimar la venta";
	}

}
