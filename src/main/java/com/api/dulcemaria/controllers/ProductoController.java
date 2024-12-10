package com.api.dulcemaria.controllers;

import com.api.dulcemaria.common.helpers.Error;
import com.api.dulcemaria.common.helpers.Result;
import com.api.dulcemaria.contracts.productos.CreateProductoRequest;
import com.api.dulcemaria.contracts.productos.GetProductoResponse;
import com.api.dulcemaria.contracts.productos.UpdateProductoRequest;
import com.api.dulcemaria.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.*;
import java.io.IOException;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    private static final String UPLOAD_DIR = "D:/repos/sistema-ventas-almacen-dulcemania/src/dulcemaria/src/main/resources/static/uploads/productos/";

    @PostMapping("/uploadImage")
    public ResponseEntity<Result<String>> uploadProductImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            Error error = new Error("validacion","El archivo enviado no cumple el formato establecido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Result<>(error));
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + extension
                    ;

            Path path = Paths.get(UPLOAD_DIR + uniqueFileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.ok(new Result<>(uniqueFileName));
        } catch (IOException e) {
            Error internalError = new Error("Unexpected","Error al procesar el archivo.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Result<>(internalError));
        }
    }

    @PostMapping
    public ResponseEntity<Result<GetProductoResponse>> createProducto(@RequestBody CreateProductoRequest request) {
        GetProductoResponse savedProducto = productoService.guardarProducto(request);
        return new ResponseEntity<>(new Result<>(savedProducto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Result<List<GetProductoResponse>>> getProductos() {
        List<GetProductoResponse> productosResponses = productoService.getProductos();
        return new ResponseEntity<>(new Result<>(productosResponses), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Result<GetProductoResponse>> updateProducto(@RequestBody UpdateProductoRequest request) {
        try {
            GetProductoResponse response = productoService.updateProductos(request);
            return new ResponseEntity<>(new Result<>(response), HttpStatus.OK);
        } catch (Exception e) {
            Error internalError = new Error("Unexpected","Error al actualizar el archivo.");
            return new ResponseEntity<>(new Result<>(internalError), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Result<Boolean>> deleteProducto(@PathVariable int id) {
        boolean response = productoService.deleteProducto(id);
        return new ResponseEntity<>(new Result<>(response), HttpStatus.OK);
    }
}
