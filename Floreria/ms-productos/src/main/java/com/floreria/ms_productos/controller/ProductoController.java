package com.floreria.ms_productos.controller;

import com.floreria.ms_productos.model.Producto;
import com.floreria.ms_productos.service.IProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final IProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscar(@PathVariable Long id) {
        Producto producto = service.buscarPorId(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@Valid @RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Producto>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @Valid @RequestBody Producto producto) {
        Producto actualizado = service.actualizar(id, producto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @PutMapping("/{id}/descontar-stock")
    public ResponseEntity<Void> descontarStock(@PathVariable Long id, @RequestParam Integer cantidad) {
        Producto producto = productoService.buscarPorId(id);

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente para realizar la venta");
        }

        producto.setStock(producto.getStock() - cantidad);
        productoService.guardar(producto);

        return ResponseEntity.ok().build();
    }
}