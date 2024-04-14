package com.matinsa.backend.controllers;

import com.matinsa.backend.entities.CategoriaProducto;
import com.matinsa.backend.services.CategoriaService;
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
@RequestMapping("categoria")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping("/combo")
    public ResponseEntity<List<CategoriaProducto>> mensaje() {
        return ResponseEntity.ok(categoriaService.leer());
    }

}
