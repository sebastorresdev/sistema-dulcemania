package com.api.dulcemaria.common.productos;

import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.models.Producto;
import com.api.dulcemaria.models.UnidadMedida;

public interface IProductoMapping {
    public Producto ToProducto(CreateProductoRequest productoRequest, Familia familia, Marca marca, UnidadMedida unidadMedida);
    public GetProductoResponse ToProductoResponse(Producto producto);
}
