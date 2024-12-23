package com.api.dulcemaria.helpers.productos;

import com.api.dulcemaria.contracts.productos.CreateProductoRequest;
import com.api.dulcemaria.contracts.productos.GetProductoResponse;
import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.models.Producto;
import com.api.dulcemaria.models.UnidadMedida;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapping implements IProductoMapping {
    @Override
    public Producto ToProducto(CreateProductoRequest productoRequest, Familia familia, Marca marca, UnidadMedida unidadMedida) {
        Producto producto = new Producto();

        producto.setCodigoInterno(productoRequest.codigoInterno());
        producto.setDescripcion(productoRequest.descripcion());
        producto.setStockMinimo(productoRequest.stockMinimo());
        producto.setFamilia(familia);
        producto.setMarca(marca);
        producto.setUnidadMedida(unidadMedida);
        producto.setPrecioUnitario(productoRequest.precioUnitario());
        producto.setCodigoBarras(productoRequest.codigoBarras());
        if (productoRequest.urlImg() == null) {
            producto.setUrlImg("box.png");
        }
        else {
            producto.setUrlImg(productoRequest.urlImg());
        }
        return producto;
    }

    @Override
    public GetProductoResponse ToProductoResponse(Producto producto) {
        return new GetProductoResponse(
                producto.getId(),
                producto.getDescripcion(),
                producto.getFamilia().getNombre(),
                producto.getMarca().getNombre(),
                producto.getEsActivo(),
                producto.getPrecioUnitario(),
                producto.getStock(),
                producto.getUrlImg(),
                producto.getStockMinimo(),
                producto.getCodigoInterno(),
                producto.getCodigoBarras(),
                producto.getUnidadMedida().getAbreviatura()
        );
    }
}
