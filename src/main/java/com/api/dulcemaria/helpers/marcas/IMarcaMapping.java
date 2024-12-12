package com.api.dulcemaria.helpers.marcas;

import com.api.dulcemaria.contracts.marcas.GetMarcaResponse;
import com.api.dulcemaria.models.Marca;

public interface IMarcaMapping {
    public GetMarcaResponse toMarcaResponse(Marca marca);
}
