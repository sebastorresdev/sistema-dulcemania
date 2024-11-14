package com.api.dulcemaria.common.productos;

import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.models.Producto;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapping implements IProductoMapping {
    @Override
    public Producto ToProducto(CreateProductoRequest productoRequest, Familia familia, Marca marca) {
        Producto producto = new Producto();

        producto.setCodigoInterno(productoRequest.codigoInterno());
        producto.setDescripcion(productoRequest.descripcion());
        producto.setStockMinimo(productoRequest.stockMinimo());
        producto.setStock(productoRequest.stock());
        producto.setFamilia(familia);
        producto.setMarca(marca);
        producto.setPrecioUnitario(productoRequest.precioUnitario());
        producto.setCodigoBarras(productoRequest.codigoBarras());
        producto.setUrlImg(productoRequest.urlImg());

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
                producto.getCodigoInterno()
        );
    }
}
