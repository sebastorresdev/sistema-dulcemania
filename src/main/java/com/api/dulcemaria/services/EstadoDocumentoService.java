package com.api.dulcemaria.services;

import com.api.dulcemaria.models.EstadoDocumento;
import com.api.dulcemaria.repositories.IEstadoDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoDocumentoService {

    @Autowired
    IEstadoDocumentoRepository _estadoDocumentoRepository;

    public List<EstadoDocumento> listarEstadoDocumentos(){
        return (List<EstadoDocumento>)_estadoDocumentoRepository.findAll();
    }
}
