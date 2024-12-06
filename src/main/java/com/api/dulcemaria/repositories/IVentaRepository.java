package com.api.dulcemaria.repositories;

import com.api.dulcemaria.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Integer> {

}
