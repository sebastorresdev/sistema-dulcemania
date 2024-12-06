package com.api.dulcemaria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dulcemaria.models.DetallePedido;

@Repository
public interface IDetallePedidoRepository extends JpaRepository<DetallePedido, Integer> {
	

}
