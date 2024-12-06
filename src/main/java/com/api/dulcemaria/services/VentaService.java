package com.api.dulcemaria.services;

import com.api.dulcemaria.models.Venta;
import com.api.dulcemaria.repositories.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService {
	@Autowired 
	IVentaRepository venta;
	
	public List<Venta> listarventas(){
		return (List<Venta>)venta.findAll();
	}
	
	public Venta guardarventa(Venta v) {
		Optional<Venta> reg=venta.findById(v.getId());
		if (!reg.isPresent()) 
			return venta.save(v);
		else
			return null;
	}
	
	public boolean eliminarventa(Integer id) {
		Optional<Venta> reg=venta.findById(id);
		if (reg.isPresent()) {
			reg.ifPresent(v -> v.setEsActivo(false));
			venta.save(reg.get());
			//ipro.deleteById(id);
			return true;
		}
		else
			return false;
	}


}
