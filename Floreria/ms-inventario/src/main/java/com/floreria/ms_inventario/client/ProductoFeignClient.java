package com.floreria.ms_inventario.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;

@FeignClient(name = "ms-productos")
public interface ProductoFeignClient {
    @GetMapping("/api/productos/{id}")
    ResponseEntity<Map<String, Object>> obtenerPorId(@PathVariable("id") Long id);
}