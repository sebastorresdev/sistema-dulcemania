package com.api.dulcemaria.common.marcas;

import com.api.dulcemaria.models.Marca;

public interface IMarcaMapping {
    public GetMarcaResponse toMarcaResponse(Marca marca);
}
