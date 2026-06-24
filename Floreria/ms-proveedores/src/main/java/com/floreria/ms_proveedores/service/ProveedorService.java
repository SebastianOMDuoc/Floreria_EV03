package com.floreria.ms_proveedores.service;

import com.floreria.ms_proveedores.model.Proveedor;
import com.floreria.ms_proveedores.repository.ProveedorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProveedorService {
    private final ProveedorRepository repository;

    public List<Proveedor> obtenerTodos() { return repository.findAll(); }
    public Proveedor guardar(Proveedor prov) { return repository.save(prov); }
}