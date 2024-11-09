package com.api.dulcemaria.controllers;

import com.api.dulcemaria.common.productos.CreateProductoRequest;
import com.api.dulcemaria.common.productos.GetProductoResponse;
import com.api.dulcemaria.models.Producto;
import com.api.dulcemaria.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<Producto> createProducto(@RequestBody CreateProductoRequest request) {
        Producto savedProducto = productoService.guardarProducto(request);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetProductoResponse>> getProductos() {
        List<GetProductoResponse> productosResponses = productoService.obtenerProductos();
        if (productosResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productosResponses, HttpStatus.OK);
    }
}
