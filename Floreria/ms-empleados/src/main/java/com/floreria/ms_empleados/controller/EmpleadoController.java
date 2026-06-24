package com.floreria.ms_empleados.controller;

import com.floreria.ms_empleados.model.Empleado;
import com.floreria.ms_empleados.service.EmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService service;

    @GetMapping
    public ResponseEntity<List<Empleado>> listar() { return ResponseEntity.ok(service.obtenerTodos()); }

    @PostMapping
    public ResponseEntity<Empleado> crear(@Valid @RequestBody Empleado emp) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(emp));
    }
}