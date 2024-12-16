package com.api.dulcemaria.controllers;

import com.api.dulcemaria.contracts.usuarios.CreateUsuarioRequest;
import com.api.dulcemaria.contracts.usuarios.GetUsuarioResponse;
import com.api.dulcemaria.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;

    @PostMapping
    public ResponseEntity<GetUsuarioResponse> createProducto(@RequestBody CreateUsuarioRequest request) {
        return new ResponseEntity<>( _usuarioService.registrarUsuario(request), HttpStatus.CREATED);
    }

    @GetMapping("/{identificador}")
    public ResponseEntity<?> buscarUsuario(@PathVariable String identificador){
        return ResponseEntity.ok(_usuarioService.buscarUsuarioPorIdentificador(identificador));
    }
}
