package com.floreria.ms_compras.controller;

import com.floreria.ms_compras.model.Compra;
import com.floreria.ms_compras.service.CompraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/compras")
@RequiredArgsConstructor
public class CompraController {
    private final CompraService service;

    @GetMapping
    public ResponseEntity<List<Compra>> listar() { return ResponseEntity.ok(service.obtenerTodas()); }

    @PostMapping
    public ResponseEntity<Compra> crear(@Valid @RequestBody Compra compra) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(compra));
    }
}