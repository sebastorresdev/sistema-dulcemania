package com.api.dulcemaria.repositories;

import com.api.dulcemaria.models.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer> {
	Optional<Proveedor> findByruc(String ruc);
	
	
}
