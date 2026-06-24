package com.floreria.ms_despachos.service;

import com.floreria.ms_despachos.model.Despacho;
import com.floreria.ms_despachos.repository.DespachoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DespachoService {
    private final DespachoRepository repository;

    public Despacho guardar(Despacho despacho) {
        despacho.setEstado("PENDIENTE");
        return repository.save(despacho);
    }
}