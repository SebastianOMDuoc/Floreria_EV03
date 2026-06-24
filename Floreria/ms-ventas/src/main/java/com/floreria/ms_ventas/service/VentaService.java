package com.floreria.ms_ventas.service;

import com.floreria.ms_ventas.client.ProductoFeignClient;
import com.floreria.ms_ventas.model.Venta;
import com.floreria.ms_ventas.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class VentaService {
    private final VentaRepository repository;
    private final ProductoFeignClient productoFeignClient;

    public Venta procesarVenta(Venta venta) {
        ResponseEntity<Map<String, Object>> response = productoFeignClient.obtenerPorId(venta.getProductoId());

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            Map<String, Object> prodData = response.getBody();
            Double precio = (Double) prodData.get("precio");

            venta.setTotalCalculado(precio * venta.getCantidad());

            productoFeignClient.descontarStock(venta.getProductoId(), venta.getCantidad());

            return repository.save(venta);
        } else {
            throw new RuntimeException("No se pudo recuperar los datos del producto vía Feign.");
        }
    }
}