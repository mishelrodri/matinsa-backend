package com.matinsa.backend.controllers;

import com.matinsa.backend.entities.Unidad;
import com.matinsa.backend.services.UnidadService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("unidad")
public class UnidadController {

    private final UnidadService unidadService;

    @GetMapping("/combo")
    public ResponseEntity<List<Unidad>> mensaje() {
        return ResponseEntity.ok(unidadService.leer());
    }
}
