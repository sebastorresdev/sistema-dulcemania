package com.api.dulcemaria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.dulcemaria.models.UnidadMedida;

public interface IUnidadMedidaRepository extends JpaRepository<UnidadMedida, Integer> {
    Optional<UnidadMedida> findBynombre(String nombre);

}