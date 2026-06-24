package com.floreria.ms_ventas.repository;

import com.floreria.ms_ventas.model.Venta;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface VentaRepository extends CrudRepository<Venta, Long> {
    List<Venta> findAll();
}