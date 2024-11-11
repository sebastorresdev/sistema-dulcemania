package com.api.dulcemaria.services;

import com.api.dulcemaria.common.productos.CreateProductoRequest;
import com.api.dulcemaria.common.productos.GetProductoResponse;
import com.api.dulcemaria.common.productos.IProductoMapping;
import com.api.dulcemaria.models.Familia;
import com.api.dulcemaria.models.Marca;
import com.api.dulcemaria.models.Producto;
import com.api.dulcemaria.repositories.IFamiliaRepository;
import com.api.dulcemaria.repositories.IMarcaRepository;
import com.api.dulcemaria.repositories.IProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    @Autowired
    private IProductosRepository productosRepository;

    @Autowired
    private IFamiliaRepository familiaRepository;

    @Autowired
    private IProductoMapping productoMapping;

    @Autowired
    private IMarcaRepository _marcaRepository;

    public Producto guardarProducto(CreateProductoRequest productoRequest) {

        Optional<Familia> familia = familiaRepository.findById(productoRequest.idFamilia());

        if (familia.isEmpty()) {
            throw new RuntimeException("Familia no encontrada con ID: " + productoRequest.idFamilia());
        }

        Optional<Marca> marca = _marcaRepository.findById(productoRequest.idMarca());

        if (marca.isEmpty()) {
            throw new RuntimeException("Marca no encontrada con ID: " + productoRequest.idMarca());
        }

        return productosRepository.save(productoMapping.ToProducto(productoRequest, familia.get(), marca.get()));
    }

    public List<GetProductoResponse> obtenerProductos() {
        List<Producto> productos = productosRepository.findAll();


        return productos.stream()
                 .map(producto -> productoMapping.ToProductoResponse(producto))
                 .collect(Collectors.toList());
    }
}
