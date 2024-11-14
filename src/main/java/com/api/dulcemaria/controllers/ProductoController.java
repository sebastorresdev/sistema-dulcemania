package com.api.dulcemaria.controllers;

import com.api.dulcemaria.common.helpers.Error;
import com.api.dulcemaria.common.helpers.Result;
import com.api.dulcemaria.common.productos.CreateProductoRequest;
import com.api.dulcemaria.common.productos.GetImgNameResponse;
import com.api.dulcemaria.common.productos.GetProductoResponse;
import com.api.dulcemaria.models.Producto;
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

    private static final String UPLOAD_DIR = "D:/Proyectos/sistema-ventas-almacen-dulcemania/src/dulcemaria/src/main/resources/static/uploads/productos/";

    @PostMapping("/uploadImage")
    public ResponseEntity<Result<GetImgNameResponse>> uploadProductImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            var error = Error.Validation("El archivo enviado no cumple el formato establecido");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Result<>(error));
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + extension;

            Path path = Paths.get(UPLOAD_DIR + uniqueFileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            GetImgNameResponse response = new GetImgNameResponse(uniqueFileName);
            return ResponseEntity.ok(new Result<>(response));
        } catch (IOException e) {
            Error internalError = Error.Unexpected("Error al procesar el archivo.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Result<>(internalError));
        }
    }

    @PostMapping
    public ResponseEntity<GetProductoResponse> createProducto(@RequestBody CreateProductoRequest request) {
        GetProductoResponse savedProducto = productoService.guardarProducto(request);
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
