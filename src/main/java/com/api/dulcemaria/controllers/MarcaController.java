package com.api.dulcemaria.controllers;

import com.api.dulcemaria.contracts.marcas.GetMarcaResponse;
import com.api.dulcemaria.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/marcas")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<GetMarcaResponse>> getMarcas() {
        List<GetMarcaResponse> marcaResponses = marcaService.getMarcas();
        if (marcaResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(marcaResponses, HttpStatus.OK);
    }
}
