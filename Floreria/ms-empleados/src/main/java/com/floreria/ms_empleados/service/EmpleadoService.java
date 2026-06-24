package com.floreria.ms_empleados.service;

import com.floreria.ms_empleados.model.Empleado;
import com.floreria.ms_empleados.repository.EmpleadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpleadoService {
    private final EmpleadoRepository repository;

    public List<Empleado> obtenerTodos() { return repository.findAll(); }
    public Empleado guardar(Empleado emp) { return repository.save(emp); }
}