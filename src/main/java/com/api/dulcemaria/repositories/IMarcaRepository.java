package com.api.dulcemaria.repositories;

import com.api.dulcemaria.models.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMarcaRepository extends JpaRepository<Marca, Integer> {
}
