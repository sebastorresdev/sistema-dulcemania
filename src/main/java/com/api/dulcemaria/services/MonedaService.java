package com.api.dulcemaria.services;

import com.api.dulcemaria.models.Moneda;
import com.api.dulcemaria.repositories.IMonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonedaService {
	@Autowired
	IMonedaRepository moneda;
	
	public List<Moneda> listarmonedas(){
		return (List<Moneda>)moneda.findAll();
	}
}
