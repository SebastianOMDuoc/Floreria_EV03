package com.floreria.ms_inventario.controller;

import com.floreria.ms_inventario.model.Inventario;
import com.floreria.ms_inventario.service.InventarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventario")
@RequiredArgsConstructor
public class InventarioController {
    private final InventarioService service;

    @PostMapping
    public ResponseEntity<Inventario> crear(@Valid @RequestBody Inventario inventario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarEnBodega(inventario));
    }
}