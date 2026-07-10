package com.floreria.ms_productos.service;

import com.floreria.ms_productos.model.Producto;
import com.floreria.ms_productos.repository.ProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class ProductoServiceTest {

    Producto producto;

    @Autowired
    private IProductoService productoService;

    @MockitoBean
    private ProductoRepository productoRepository;

    @Test
    public void testFindById() {
        Long id = 1L;
        Producto productoLocal = crearProducto();
        when(productoRepository.findById(id)).thenReturn(Optional.of(productoLocal));

        Producto found = productoService.buscarPorId(id);
        assertNotNull(found);
        assertEquals(id, found.getId());
    }

    @Test
    public void saveProducto() {
        Producto productoLocal = crearProducto();
        when(productoRepository.save(productoLocal)).thenReturn(productoLocal);

        Producto productoActual = productoService.guardar(productoLocal);
        assertNotNull(productoActual);
        assertEquals(1L, productoActual.getId().longValue());
    }

    public Producto crearProducto() {
        producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Rosas Rojas");
        producto.setPrecio(1500.0);
        producto.setStock(50);
        return producto;
    }
}