package com.floreria.ms_productos.controller;

import com.floreria.ms_productos.model.Producto;
import com.floreria.ms_productos.service.IProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IProductoService productoService;

    @Autowired
    private ObjectMapper objectMapper;

    private Producto producto;

    @BeforeEach
    void setUp() {
        producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Rosas Rojas");
        producto.setPrecio(1500.0);
        producto.setStock(50);
    }

    @Test
    public void testAllProductos() throws Exception {
        when(productoService.obtenerTodos()).thenReturn(List.of(producto));

        mockMvc.perform(get("/api/productos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Rosas Rojas"))
                .andExpect(jsonPath("$[0].precio").value(1500.0))
                .andExpect(jsonPath("$[0].stock").value(50));
    }

    @Test
    public void testFindById() throws Exception {
        when(productoService.buscarPorId(1L)).thenReturn(producto);

        mockMvc.perform(get("/api/productos/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("Rosas Rojas"))
                .andExpect(jsonPath("$.precio").value(1500.0))
                .andExpect(jsonPath("$.stock").value(50));
    }

    @Test
    public void testCrearProducto() throws Exception {
        when(productoService.guardar(any(Producto.class))).thenReturn(producto);

        mockMvc.perform(post("/api/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("Rosas Rojas"))
                .andExpect(jsonPath("$.precio").value(1500.0))
                .andExpect(jsonPath("$.stock").value(50));
    }

    @Test
    public void testEliminarProducto() throws Exception {
        doNothing().when(productoService).eliminar(1L);

        mockMvc.perform(delete("/api/productos/{id}", 1L))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testBuscarPorNombre() throws Exception {
        when(productoService.buscarPorNombre("Rosas Rojas")).thenReturn(List.of(producto));

        mockMvc.perform(get("/api/productos/nombre/{nombre}", "Rosas Rojas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].nombre").value("Rosas Rojas"));
    }

    @Test
    public void testActualizarProducto() throws Exception {
        when(productoService.actualizar(eq(1L), any(Producto.class))).thenReturn(producto);

        mockMvc.perform(put("/api/productos/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(producto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("Rosas Rojas"));
    }

    @Test
    public void testDescontarStockExitoso() throws Exception {
        when(productoService.buscarPorId(1L)).thenReturn(producto);
        when(productoService.guardar(any(Producto.class))).thenReturn(producto);

        mockMvc.perform(put("/api/productos/{id}/descontar-stock", 1L)
                        .param("cantidad", "10"))
                .andExpect(status().isOk());
    }
}