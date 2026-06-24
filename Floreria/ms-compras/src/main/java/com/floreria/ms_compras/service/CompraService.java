package com.floreria.ms_compras.service;

import com.floreria.ms_compras.model.Compra;
import com.floreria.ms_compras.repository.CompraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompraService {
    private final CompraRepository repository;

    public List<Compra> obtenerTodas() { return repository.findAll(); }
    public Compra guardar(Compra compra) { return repository.save(compra); }
}