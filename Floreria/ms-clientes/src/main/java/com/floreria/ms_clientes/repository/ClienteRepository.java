package com.floreria.ms_clientes.repository;

import com.floreria.ms_clientes.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    // Cumple la instrucción explícita del enunciado: findByRut()
    Optional<Cliente> findByRut(String rut);
}