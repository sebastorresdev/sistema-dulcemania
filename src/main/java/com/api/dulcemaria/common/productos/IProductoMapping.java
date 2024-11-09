package com.api.dulcemaria.common.productos;

import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.models.Producto;

public interface IProductoMapping {
    public Producto ToProducto(CreateProductoRequest productoRequest, Familia familia, Marca marca);
    public GetProductoResponse ToProductoResponse(Producto producto);
}
