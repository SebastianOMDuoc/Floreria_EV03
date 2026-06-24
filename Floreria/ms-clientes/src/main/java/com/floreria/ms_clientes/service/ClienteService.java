package com.floreria.ms_clientes.service;

import com.floreria.ms_clientes.model.Cliente;
import com.floreria.ms_clientes.repository.ClienteRepository;
import com.floreria.ms_clientes.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public Cliente guardar(Cliente cliente) { return repository.save(cliente); }

    public Cliente buscarPorRut(String rut) {
        return repository.findByRut(rut)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado con RUT: " + rut));
    }
}