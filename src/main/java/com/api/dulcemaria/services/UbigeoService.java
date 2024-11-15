package com.api.dulcemaria.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dulcemaria.models.Ubigeo;
import com.api.dulcemaria.repositories.IUbigeoRepository;

@Service
public class UbigeoService {
	@Autowired
	IUbigeoRepository ubi; 
	
	public List<Ubigeo> listarubigeo(){
		return (List<Ubigeo>)ubi.findAll();
	}
	
	
}
