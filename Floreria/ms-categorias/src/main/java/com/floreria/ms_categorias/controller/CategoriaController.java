package com.floreria.ms_categorias.controller;

import com.floreria.ms_categorias.model.Categoria;
import com.floreria.ms_categorias.service.ICategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final ICategoriaService service;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(service.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}