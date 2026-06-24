package com.floreria.ms_categorias.repository;

import com.floreria.ms_categorias.model.Categoria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findAll();
    List<Categoria> findByNombre(String nombre);
}
