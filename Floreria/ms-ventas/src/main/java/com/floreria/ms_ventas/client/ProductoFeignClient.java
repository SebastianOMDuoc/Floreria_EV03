package com.floreria.ms_ventas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "ms-productos")
public interface ProductoFeignClient {
    @GetMapping("/api/productos/{id}")
    ResponseEntity<Map<String, Object>> obtenerPorId(@PathVariable("id") Long id);

    @PutMapping("/api/productos/{id}/descontar-stock")
    ResponseEntity<Void> descontarStock(@PathVariable("id") Long id, @RequestParam("cantidad") Integer cantidad);
}