package com.floreria.ms_empleados.repository;

import com.floreria.ms_empleados.model.Empleado;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
    List<Empleado> findAll();
}