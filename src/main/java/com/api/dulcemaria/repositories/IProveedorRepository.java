package com.api.dulcemaria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dulcemaria.models.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {
	Optional<Proveedor> findByruc(String ruc);
	
	
}