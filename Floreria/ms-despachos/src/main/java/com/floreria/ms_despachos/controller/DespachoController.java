package com.floreria.ms_despachos.controller;

import com.floreria.ms_despachos.model.Despacho;
import com.floreria.ms_despachos.service.DespachoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/despachos")
@RequiredArgsConstructor
public class DespachoController {
    private final DespachoService service;

    @PostMapping
    public ResponseEntity<Despacho> crear(@Valid @RequestBody Despacho despacho) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(despacho));
    }
}