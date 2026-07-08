package com.floreria.ms_ventas.controller;

import com.floreria.ms_ventas.model.Venta;
import com.floreria.ms_ventas.service.VentaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
@Tag(name = "Ventas", description = "API para la gestión y procesamiento de ventas de la florería")
public class VentaController {
    private final VentaService service;

    @PostMapping
    @Operation(summary = "Registrar una nueva venta", description = "Procesa una venta de flores, descuenta stock de inventario (si corresponde) y genera el comprobante")
    public ResponseEntity<Venta> crear(@Valid @RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.procesarVenta(venta));
    }
}