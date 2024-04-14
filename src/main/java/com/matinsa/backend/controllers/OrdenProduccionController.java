package com.matinsa.backend.controllers;

import com.matinsa.backend.dto.CantidadDto;
import com.matinsa.backend.dto.OrdenProduccionDto;
import com.matinsa.backend.entities.OrdenProduccion;
import com.matinsa.backend.security.dto.Mensaje;
import com.matinsa.backend.services.OrdenProducionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("orden-produccion")
public class OrdenProduccionController {

    public final OrdenProducionService ordenProducionService;

    @GetMapping
    public ResponseEntity<Page<OrdenProduccion>> mensaje(Pageable pageable){
        return ResponseEntity.ok(ordenProducionService.listar(pageable));
    }

    @PostMapping("verificar-existencias")
    public ResponseEntity<Mensaje> verificarExistencias(@RequestBody CantidadDto dto){
        return ResponseEntity.ok(ordenProducionService.verificarExistencias(dto));
    }

    @PostMapping
    public ResponseEntity<Mensaje> crear(@RequestBody OrdenProduccionDto dto){
        return ResponseEntity.ok(ordenProducionService.crear(dto));
    }

}
