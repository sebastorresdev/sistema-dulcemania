package com.api.dulcemaria.controllers;

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
    public ResponseEntity<String> uploadProductImage(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error al intentar cargar una imagen");
        }

        try {
            String originalFileName = file.getOriginalFilename();
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + extension
                    ;

            Path path = Paths.get(UPLOAD_DIR + uniqueFileName);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

            return ResponseEntity.ok("\"" + uniqueFileName + "\"");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error no controlado");
        }
    }

    @PostMapping
    public ResponseEntity<GetProductoResponse> createProducto(@RequestBody CreateProductoRequest request) {
        GetProductoResponse savedProducto = productoService.guardarProducto(request);
        return new ResponseEntity<>(savedProducto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<GetProductoResponse>> getProductos() {
        List<GetProductoResponse> productosResponses = productoService.getProductos();
        return new ResponseEntity<>(productosResponses, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<GetProductoResponse> updateProducto(@RequestBody UpdateProductoRequest request) {
        try {
            GetProductoResponse response = productoService.updateProductos(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteProducto(@PathVariable int id) {
        boolean response = productoService.deleteProducto(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
