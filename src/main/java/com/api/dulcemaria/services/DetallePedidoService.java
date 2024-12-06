package com.api.dulcemaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dulcemaria.models.DetallePedido;
import com.api.dulcemaria.repositories.IDetallePedidoRepository;


@Service
public class DetallePedidoService {
	@Autowired
	IDetallePedidoRepository detalle; 
	
	public List<DetallePedido> listarpedido(){
		return (List<DetallePedido>)detalle.findAll();
	}
	
	

}
