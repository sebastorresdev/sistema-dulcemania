package com.api.dulcemaria.repositories;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dulcemaria.models.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Integer> {

}