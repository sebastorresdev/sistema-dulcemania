package com.api.dulcemaria.controllers;

import com.api.dulcemaria.common.productos.CreateProductoRequest;
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

@RestController
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    private static final String UPLOAD_DIR = "D:/Proyectos/sistema-ventas-almacen-dulcemania/src/dulcemaria/src/main/resources/static/uploads/productos/";

    @PostMapping("/uploadImage")
    public ResponseEntity<String> uploadProductImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No file uploaded");
        }

        try {
            String fileName = file.getOriginalFilename();
            Path path = Paths.get(UPLOAD_DIR + fileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            // Devuelve la URL de la imagen cargada
            String fileUrl = "/uploads/productos/" + fileName;
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving file");
        }
    }

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
