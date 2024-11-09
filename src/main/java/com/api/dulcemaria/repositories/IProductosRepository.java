package com.api.dulcemaria.repositories;

import com.api.dulcemaria.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductosRepository extends JpaRepository<Producto, Integer> {
}
