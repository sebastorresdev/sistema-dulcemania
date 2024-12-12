package com.api.dulcemaria.services;

import com.api.dulcemaria.helpers.proveedores.IProveedorMapping;
import com.api.dulcemaria.contracts.proveedores.CreateProveedorRequest;
import com.api.dulcemaria.models.Proveedor;
import com.api.dulcemaria.repositories.IProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProveedorServicio {

	@Autowired 
	IProveedorRepository _proveedorRepository;
	@Autowired
	IProveedorMapping _mapping;

	public List<Proveedor> listarProveedores(){
		List<Proveedor> proveedores = _proveedorRepository.findAll();
		return proveedores.stream().filter(p -> p.getEsActivo()).collect(Collectors.toList());
	}
	
	public Proveedor guardarProveedor(CreateProveedorRequest proveedorRequest) {

		Proveedor proveedor = _mapping.convertToProveedor(proveedorRequest);

		return _proveedorRepository.save(proveedor);
	}
	
	public boolean eliminarproveedor(Integer id) {
		Optional<Proveedor> reg=_proveedorRepository.findById(id);
		if (reg.isPresent()) {
			reg.ifPresent(p -> p.setEsActivo(false));
			_proveedorRepository.save(reg.get());
			//_proveedorRepository.deleteById(id);
			return true;
		}
		else
			return false;
	}
	
	public Proveedor actualizarProveedor(Proveedor p) {
	    Optional<Proveedor> reg = _proveedorRepository.findById(p.getId());
	    if (reg.isPresent()) {
	        Proveedor proveedorExistente = reg.get();
	        
	        proveedorExistente.setContacto(p.getContacto());
	        proveedorExistente.setRuc(p.getRuc());
	        proveedorExistente.setRazonSocial(p.getRazonSocial());
	        proveedorExistente.setTelefono1(p.getTelefono1());
	        proveedorExistente.setTelefono2(p.getTelefono2());
	        proveedorExistente.setDireccion(p.getDireccion());
	        proveedorExistente.setCorreo(p.getCorreo());
	        proveedorExistente.setObservacionDireccion(p.getObservacionDireccion());
	        proveedorExistente.setEsActivo(p.getEsActivo());
	        proveedorExistente.setUbigeo(p.getUbigeo());
	        
	        return _proveedorRepository.save(proveedorExistente);
	    } else {
	        return null;
	    }  
	}
	
	public Optional<Proveedor> buscarruc(String ruc){
		return _proveedorRepository.findByruc(ruc);
	}
	
	
	
	

	
}


