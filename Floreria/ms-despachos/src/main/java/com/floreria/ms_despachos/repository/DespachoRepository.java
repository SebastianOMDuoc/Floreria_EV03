package com.floreria.ms_despachos.repository;

import com.floreria.ms_despachos.model.Despacho;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DespachoRepository extends CrudRepository<Despacho, Long> {
    List<Despacho> findByEstado(String estado);
}