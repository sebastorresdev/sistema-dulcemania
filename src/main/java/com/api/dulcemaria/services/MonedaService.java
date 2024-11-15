package com.api.dulcemaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.dulcemaria.models.Moneda;
import com.api.dulcemaria.repositories.IMonedaRepository;



@Service
public class MonedaService {
    @Autowired 
    IMonedaRepository imon;

    public List<Moneda> listarmoneda(){
		return (List<Moneda>)imon.findAll();
	}
	

}
