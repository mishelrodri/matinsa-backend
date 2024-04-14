package com.matinsa.backend.controllers;

import com.matinsa.backend.entities.Cliente;
import com.matinsa.backend.services.ClienteService;
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
@RequestMapping("cliente")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/combo")
    public ResponseEntity<List<Cliente>> mensaje(){
        return ResponseEntity.ok(clienteService.leer());
    }

}
