package com.floreria.ms_proveedores.controller;

import com.floreria.ms_proveedores.model.Proveedor;
import com.floreria.ms_proveedores.service.ProveedorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
@RequiredArgsConstructor
public class ProveedorController {
    private final ProveedorService service;

    @GetMapping
    public ResponseEntity<List<Proveedor>> listar() { return ResponseEntity.ok(service.obtenerTodos()); }

    @PostMapping
    public ResponseEntity<Proveedor> crear(@Valid @RequestBody Proveedor prov) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(prov));
    }
}