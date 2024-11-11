package com.api.dulcemaria.controllers;

import com.api.dulcemaria.common.familias.GetFamiliaResponse;
import com.api.dulcemaria.common.productos.GetProductoResponse;
import com.api.dulcemaria.services.FamiliaService;
import com.api.dulcemaria.services.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/familias")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @GetMapping
    public ResponseEntity<List<GetFamiliaResponse>> getFamilias() {
        List<GetFamiliaResponse> familiaResponses = familiaService.getFamilias();
        if (familiaResponses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(familiaResponses, HttpStatus.OK);
    }
}
