package com.api.dulcemaria.helpers.familias;

import com.api.dulcemaria.contracts.familias.GetFamiliaResponse;
import com.api.dulcemaria.models.Familia;
import org.springframework.stereotype.Component;

@Component
public class FamiliaMapping implements IFamiliaMapping{
    @Override
    public GetFamiliaResponse toFamiliaResponse(Familia familia) {
        return new GetFamiliaResponse(
                familia.getId(),
                familia.getNombre()
        );
    }
}
