package com.floreria.ms_alertas.controller;

import com.floreria.ms_alertas.model.Alerta;
import com.floreria.ms_alertas.service.AlertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
public class AlertaController {
    private final AlertaService service;

    @GetMapping
    public ResponseEntity<List<Alerta>> listar() { return ResponseEntity.ok(service.obtenerTodas()); }

    @PostMapping
    public ResponseEntity<Alerta> crear(@Valid @RequestBody Alerta alerta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(alerta));
    }
}