package com.api.dulcemaria.services;

import com.api.dulcemaria.models.Compra;
import com.api.dulcemaria.repositories.ICompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {
	@Autowired 
	ICompraRepository comre;
	

	public List<Compra> listarcompras(){
		return (List<Compra>)comre.findAll();
	}


	public Optional<Compra> tipoDocumento(String tipoDocumento){
		return comre.findBytipoDocumento(tipoDocumento);
	}
	
	public Compra guardarcompra(Compra c) {
		Optional<Compra> reg=comre.findById(c.getId());
		if (!reg.isPresent()) 
			return comre.save(c);
		else
			return null;
		
	}
	
	public boolean eliminarcompra(Integer id) {
		Optional<Compra> reg=comre.findById(id);
		if (reg.isPresent()) {
			reg.ifPresent(p -> p.setEsActivo(false));
			comre.save(reg.get());
			
			return true;
		}
		else
			return false;
	}
		
}
