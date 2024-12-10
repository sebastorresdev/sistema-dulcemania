package com.api.dulcemaria.services;

import com.api.dulcemaria.contracts.familias.GetFamiliaResponse;
import com.api.dulcemaria.common.familias.IFamiliaMapping;
import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.repositories.IFamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FamiliaService {

    @Autowired
    private IFamiliaRepository familiaRepository;

    @Autowired
    private IFamiliaMapping familiaMapping;

    public List<GetFamiliaResponse> getFamilias() {
        List<Familia> familias = familiaRepository.findAll();

        return familias.stream()
                .map(familia -> familiaMapping.toFamiliaResponse(familia))
                .collect(Collectors.toList());
    }
}
