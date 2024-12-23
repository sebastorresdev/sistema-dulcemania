package com.api.dulcemaria.services;

import com.api.dulcemaria.contracts.pedidos.GetDetallePedidoResponse;
import com.api.dulcemaria.helpers.productos.*;
import com.api.dulcemaria.contracts.productos.CreateProductoRequest;
import com.api.dulcemaria.contracts.productos.GetProductoResponse;
import com.api.dulcemaria.contracts.productos.UpdateProductoRequest;
import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.models.Producto;
import com.api.dulcemaria.models.UnidadMedida;
import com.api.dulcemaria.repositories.IFamiliaRepository;
import com.api.dulcemaria.repositories.IMarcaRepository;
import com.api.dulcemaria.repositories.IProductosRepository;
import com.api.dulcemaria.repositories.IUnidadMedidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private IProductosRepository _productosRepository;

    @Autowired
    private IFamiliaRepository familiaRepository;

    @Autowired
    private IProductoMapping productoMapping;

    @Autowired
    private IUnidadMedidaRepository unidadMedidaRepository;

    @Autowired
    private IMarcaRepository _marcaRepository;

    public GetProductoResponse guardarProducto(CreateProductoRequest productoRequest) {

        Familia familia = familiaRepository.findById(productoRequest.idFamilia())
                .orElseThrow(() -> new RuntimeException("Familia no encontrada con ID: " + productoRequest.idFamilia()));

        Marca marca = _marcaRepository.findById(productoRequest.idMarca())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + productoRequest.idMarca()));

        UnidadMedida unidadMedida = unidadMedidaRepository.findById(productoRequest.idUnidadMedida())
                .orElseThrow(() -> new RuntimeException("Unidad medida no encontrada con ID: " + productoRequest.idUnidadMedida()));

        Producto productoCreado = _productosRepository.save(productoMapping.ToProducto(productoRequest, familia, marca, unidadMedida));
        return productoMapping.ToProductoResponse(productoCreado);
    }

    public List<GetProductoResponse> getProductos() {
        return _productosRepository.findAll().stream()
                 .filter(Producto::getEsActivo)
                 .map(producto -> productoMapping.ToProductoResponse(producto))
                 .collect(Collectors.toList());
    }

    @Transactional
    public GetProductoResponse updateProductos(UpdateProductoRequest productoRequest) {
        Producto producto = _productosRepository.findById(productoRequest.id())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + productoRequest.id()));


        Familia familia = familiaRepository.findById(productoRequest.idFamilia())
                .orElseThrow(() -> new RuntimeException("Familia no encontrada con ID: " + productoRequest.idFamilia()));

        Marca marca = _marcaRepository.findById(productoRequest.idMarca())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + productoRequest.idMarca()));


        producto.setCodigoInterno(productoRequest.codigoInterno());
        producto.setDescripcion(productoRequest.descripcion());
        producto.setStockMinimo(productoRequest.stockMinimo());
        producto.setPrecioUnitario(productoRequest.precioUnitario());
        productoRequest.codigoBarras().ifPresent(producto::setCodigoBarras);
        productoRequest.urlImg().ifPresent(producto::setUrlImg);

        producto.setFamilia(familia);
        producto.setMarca(marca);

        return productoMapping.ToProductoResponse(producto);
    }

    @Transactional
    public boolean deleteProducto(int id) {
        Producto producto = _productosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        producto.setEsActivo(false);
        return true;
    }

    @Transactional
    public boolean actualizarStock(List<GetDetallePedidoResponse> detallePedidos) {

        for (GetDetallePedidoResponse detalle : detallePedidos) {
            Producto producto = _productosRepository.findById(detalle.idProducto())
                    .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: " + detalle.idProducto()));

            int saldo = producto.getStock() - detalle.cantidad();

            if (saldo < 0) {
                new RuntimeException("No cuenta con stock suficiente: " + detalle.idProducto());
            }

            producto.setStock(saldo);
        }
        return true;
    }


}
