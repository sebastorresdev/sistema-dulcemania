package com.api.dulcemaria.repositories;

import com.api.dulcemaria.models.MedioPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IMedioPagoRepository extends JpaRepository<MedioPago, Integer> {
	Optional<MedioPago> findBydescripcion(String descripcion);


}
