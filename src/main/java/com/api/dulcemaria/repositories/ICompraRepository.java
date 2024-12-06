package com.api.dulcemaria.repositories;

import com.api.dulcemaria.models.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ICompraRepository extends JpaRepository<Compra, Integer> {
	Optional<Compra> findBytipoDocumento(String tipoDocumento );
	


}
