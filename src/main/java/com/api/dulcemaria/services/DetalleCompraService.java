package com.api.dulcemaria.services;

import com.api.dulcemaria.models.DetalleCompra;
import com.api.dulcemaria.repositories.IDetalleCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraService {
	@Autowired 
	IDetalleCompraRepository detalle;
	
	public List<DetalleCompra> listardetallecompra(){
		return (List<DetalleCompra>)detalle.findAll();
	}
	
	public Optional<DetalleCompra> buscarid (int  id){
		return detalle.findById(id);
	}

}
