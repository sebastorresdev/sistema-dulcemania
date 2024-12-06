package com.api.dulcemaria.repositories;

import com.api.dulcemaria.models.EstadoDocumento;
import com.api.dulcemaria.models.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoDocumentoRepository extends JpaRepository<EstadoDocumento, Integer> {
}
