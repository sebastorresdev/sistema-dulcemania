package com.api.dulcemaria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dulcemaria.models.Moneda;

@Repository
public interface IMonedaRepository extends JpaRepository<Moneda, Integer>{
    Optional<Moneda> findBynombre (String nombre);

}
