package com.api.dulcemaria.services;

import com.api.dulcemaria.models.MedioPago;
import com.api.dulcemaria.repositories.IMedioPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MedioPagoService {
	@Autowired 
	IMedioPagoRepository ipago;
	
	public List<MedioPago> listarpagos(){
		return (List<MedioPago>)ipago.findAll();
	}
	
	public MedioPago guardarpago(MedioPago m) {
		Optional<MedioPago> reg=ipago.findById(m.getId());
		if (!reg.isPresent()) 
			return ipago.save(m);
		else
			return null;
		
	}
	
	public Optional<MedioPago> BuscarPorDescripcion(String descripcion){
		return ipago.findBydescripcion(descripcion);
	}
	
}
