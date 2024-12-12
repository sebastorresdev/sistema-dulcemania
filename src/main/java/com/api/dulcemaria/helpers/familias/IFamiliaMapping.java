package com.api.dulcemaria.helpers.familias;

import com.api.dulcemaria.contracts.familias.GetFamiliaResponse;
import com.api.dulcemaria.models.Familia;

public interface IFamiliaMapping {
    public GetFamiliaResponse toFamiliaResponse(Familia familia);
}
