package com.floreria.ms_productos.controller;

import com.floreria.ms_productos.model.Producto;
import com.floreria.ms_productos.service.IProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/productos") /*http://localhost:8081/api/productos*/
@RequiredArgsConstructor
@Tag(name = "Productos", description = "API para la gestión del catálogo de productos de la florería")
public class ProductoController {

    private final IProductoService service;

    @GetMapping
    @Operation(summary = "Listar todos los productos", description = "Retorna una lista completa de los productos registrados en la base de datos.")
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(service.obtenerTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar un producto por ID", description = "Devuelve los detalles de un producto específico mediante su identificador único.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado con éxito"),
            @ApiResponse(responseCode = "404", description = "El producto no existe en el sistema")
    })
    public ResponseEntity<Producto> buscar(@PathVariable Long id) {
        Producto producto = service.buscarPorId(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Registra un nuevo producto en la base de datos.")
    @ApiResponse(responseCode = "201", description = "Producto creado exitosamente")
    public ResponseEntity<Producto> crear(@Valid @RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(producto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Remueve un producto de forma permanente dado su ID.")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    @Operation(summary = "Buscar productos por nombre", description = "Filtra y devuelve los productos que coincidan con el nombre provisto.")
    public ResponseEntity<List<Producto>> buscarPorNombre(@PathVariable String nombre) {
        return ResponseEntity.ok(service.buscarPorNombre(nombre));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto", description = "Modifica los datos existentes de un producto según su ID.")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @Valid @RequestBody Producto producto) {
        Producto actualizado = service.actualizar(id, producto);
        if (actualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizado);
    }

    @PutMapping("/{id}/descontar-stock")
    @Operation(summary = "Descontar stock de un producto", description = "Disminuye el inventario disponible de un producto. Es utilizado por ms-ventas vía Feign Client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Stock descontado exitosamente"),
            @ApiResponse(responseCode = "400", description = "La cantidad solicitada supera el stock disponible")
    })
    public ResponseEntity<Void> descontarStock(@PathVariable Long id, @RequestParam Integer cantidad) {
        Producto producto = service.buscarPorId(id);

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("Stock insuficiente para realizar la venta");
        }

        producto.setStock(producto.getStock() - cantidad);
        service.guardar(producto);

        return ResponseEntity.ok().build();
    }
}