package com.floreria.ms_clientes.controller;

import com.floreria.ms_clientes.model.Cliente;
import com.floreria.ms_clientes.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> crear(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(cliente));
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<Cliente> buscarPorRut(@PathVariable String rut) {
        return ResponseEntity.ok(service.buscarPorRut(rut));
    }
}