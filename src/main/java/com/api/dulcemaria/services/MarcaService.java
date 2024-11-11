package com.api.dulcemaria.services;

import com.api.dulcemaria.common.marcas.GetMarcaResponse;
import com.api.dulcemaria.common.marcas.IMarcaMapping;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.repositories.IMarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaService {

    @Autowired
    private IMarcaRepository marcaRepository;

    @Autowired
    private IMarcaMapping marcaMapping;

    public List<GetMarcaResponse> getMarcas() {
        List<Marca> marcas = marcaRepository.findAll();

        return marcas.stream()
                .map(marca -> marcaMapping.toMarcaResponse(marca))
                .collect(Collectors.toList());
    }
}
