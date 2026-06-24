package com.floreria.ms_proveedores.repository;

import com.floreria.ms_proveedores.model.Proveedor;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {
    List<Proveedor> findAll();
}