package com.api.dulcemaria.helpers.productos;

import com.api.dulcemaria.contracts.productos.CreateProductoRequest;
import com.api.dulcemaria.contracts.productos.GetProductoResponse;
import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.models.Producto;
import com.api.dulcemaria.models.UnidadMedida;

public interface IProductoMapping {
    public Producto ToProducto(CreateProductoRequest productoRequest, Familia familia, Marca marca, UnidadMedida unidadMedida);
    public GetProductoResponse ToProductoResponse(Producto producto);
}
