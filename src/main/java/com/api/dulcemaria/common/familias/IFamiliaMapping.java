package com.api.dulcemaria.common.familias;

import com.api.dulcemaria.models.Familia;

public interface IFamiliaMapping {
    public GetFamiliaResponse toFamiliaResponse(Familia familia);
}
