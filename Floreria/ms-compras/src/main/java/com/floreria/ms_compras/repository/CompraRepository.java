package com.floreria.ms_compras.repository;

import com.floreria.ms_compras.model.Compra;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface CompraRepository extends CrudRepository<Compra, Long> {
    List<Compra> findAll();
}