package com.floreria.ms_alertas.service;

import com.floreria.ms_alertas.model.Alerta;
import com.floreria.ms_alertas.repository.AlertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertaService {
    private final AlertaRepository repository;

    public List<Alerta> obtenerTodas() { return repository.findAll(); }
    public Alerta guardar(Alerta alerta) { return repository.save(alerta); }
}