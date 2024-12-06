package com.api.dulcemaria.repositories;


import com.api.dulcemaria.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer>  {
	Optional<Cliente> findBynumeroDocumento(String numeroDocumento);

}
