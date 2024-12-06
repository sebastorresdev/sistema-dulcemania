package com.api.dulcemaria.repositories;


import com.api.dulcemaria.models.DireccionCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDireccionClienteRepository extends JpaRepository<DireccionCliente, Integer> {
}
