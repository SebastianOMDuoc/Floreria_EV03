package com.floreria.ms_inventario.service;

import com.floreria.ms_inventario.client.ProductoFeignClient;
import com.floreria.ms_inventario.model.Inventario;
import com.floreria.ms_inventario.repository.InventarioRepository;
import com.floreria.ms_inventario.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InventarioService {
    private final InventarioRepository repository;
    private final ProductoFeignClient productoFeignClient;

    public Inventario registrarEnBodega(Inventario inventario) {
        // LLAMADA FEIGN: Validamos si el producto existe realmente en ms-productos
        try {
            ResponseEntity<Map<String, Object>> response = productoFeignClient.obtenerPorId(inventario.getProductoId());
            if (!response.getStatusCode().is2xxSuccessful()) {
                throw new ResourceNotFoundException("El producto indicado no existe en el catálogo global.");
            }
        } catch (Exception e) {
            throw new ResourceNotFoundException("Error al conectar con ms-productos o producto no existente.");
        }

        return repository.save(inventario);
    }
}