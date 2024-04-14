package com.matinsa.backend.controllers;

import com.matinsa.backend.dto.ProductoDto;
import com.matinsa.backend.entities.Producto;
import com.matinsa.backend.security.dto.Mensaje;
import com.matinsa.backend.services.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("producto")
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/combo/{id}")
    public ResponseEntity<List<Producto>> combo(@PathVariable Long id){
        return ResponseEntity.ok(productoService.findAllProductsByCategoria(id));
    }

    @GetMapping("/combo-materia-prima")
    public ResponseEntity<List<Producto>> materiaPrima(){
        return ResponseEntity.ok(productoService.findAllMateriaPrima());
    }

    @PostMapping
    public ResponseEntity<Mensaje> crear(@RequestBody @Valid ProductoDto productoDto){
        return ResponseEntity.ok(productoService.crear(productoDto));
    }

}
