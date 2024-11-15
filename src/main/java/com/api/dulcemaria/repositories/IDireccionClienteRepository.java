package com.api.dulcemaria.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.api.dulcemaria.models.DireccionCliente;

@Repository
public interface IDireccionClienteRepository extends JpaRepository<DireccionCliente, Integer> {
    
}
