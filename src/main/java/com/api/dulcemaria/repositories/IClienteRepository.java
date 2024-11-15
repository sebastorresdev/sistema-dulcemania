package com.api.dulcemaria.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.dulcemaria.models.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>  {
	Optional<Cliente> findBynumeroDocumento(String numeroDocumento);

}

