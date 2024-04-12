package com.matinsa.backend.controllers;

import com.matinsa.backend.dto.ProductoDto;
import com.matinsa.backend.security.dto.Mensaje;
import com.matinsa.backend.services.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("producto")
public class ProductoController {

    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<Mensaje> crear(@RequestBody @Valid ProductoDto productoDto){
        return ResponseEntity.ok(productoService.crear(productoDto));
    }

}
