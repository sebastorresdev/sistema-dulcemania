package com.api.dulcemaria.helpers.marcas;

import com.api.dulcemaria.contracts.marcas.GetMarcaResponse;
import com.api.dulcemaria.models.Marca;
import org.springframework.stereotype.Component;

@Component
public class MarcaMapping implements IMarcaMapping{
    @Override
    public GetMarcaResponse toMarcaResponse(Marca marca) {
        return new GetMarcaResponse(
                marca.getId(),
                marca.getNombre()
        );
    }
}
