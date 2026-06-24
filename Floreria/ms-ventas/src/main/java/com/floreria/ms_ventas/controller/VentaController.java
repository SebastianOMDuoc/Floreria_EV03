package com.floreria.ms_ventas.controller;

import com.floreria.ms_ventas.model.Venta;
import com.floreria.ms_ventas.service.VentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {
    private final VentaService service;

    @PostMapping
    public ResponseEntity<Venta> crear(@Valid @RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.procesarVenta(venta));
    }
}