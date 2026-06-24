package com.floreria.ms_categorias.service;

import com.floreria.ms_categorias.model.Categoria;
import java.util.List;

public interface ICategoriaService {
    List<Categoria> obtenerTodas();
    Categoria guardar(Categoria categoria);
    Categoria buscarPorId(Long id);
    void eliminar(Long id);
}