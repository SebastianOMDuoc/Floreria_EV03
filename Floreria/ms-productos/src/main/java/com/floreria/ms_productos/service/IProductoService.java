package com.floreria.ms_productos.service;

import com.floreria.ms_productos.model.Producto;
import java.util.List;

public interface IProductoService {
    List<Producto> obtenerTodos();
    Producto guardar(Producto producto);
    Producto buscarPorId(Long id);
    void eliminar(Long id);
    Producto actualizar(Long id, Producto producto);
    List<Producto> buscarPorNombre(String nombre);
}