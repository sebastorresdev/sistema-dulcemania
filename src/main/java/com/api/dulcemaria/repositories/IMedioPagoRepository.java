package com.api.dulcemaria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dulcemaria.models.MedioPago;

@Repository
public interface IMedioPagoRepository extends JpaRepository<MedioPago, Integer> {
	Optional<MedioPago> findBydescripcion(String descripcion);


}
