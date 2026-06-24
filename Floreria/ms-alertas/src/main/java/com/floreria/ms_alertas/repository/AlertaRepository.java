package com.floreria.ms_alertas.repository;

import com.floreria.ms_alertas.model.Alerta;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AlertaRepository extends CrudRepository<Alerta, Long> {
    List<Alerta> findAll();
    List<Alerta> findByTipo(String tipo); // Método personalizado
}