package com.floreria.ms_inventario.repository;

import com.floreria.ms_inventario.model.Inventario;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface InventarioRepository extends CrudRepository<Inventario, Long> {
    List<Inventario> findAll();
}