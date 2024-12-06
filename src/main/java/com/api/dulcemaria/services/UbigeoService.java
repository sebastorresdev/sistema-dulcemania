package com.api.dulcemaria.services;

import com.api.dulcemaria.models.Ubigeo;
import com.api.dulcemaria.repositories.IUbigeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoService {
	@Autowired
	IUbigeoRepository ubi; 
	
	public List<Ubigeo> listarubigeo(){
		return (List<Ubigeo>)ubi.findAll();
	}
	
	
}
