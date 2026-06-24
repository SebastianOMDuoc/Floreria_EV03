package com.floreria.ms_categorias.service;

import com.floreria.ms_categorias.model.Categoria;
import com.floreria.ms_categorias.repository.CategoriaRepository;
import com.floreria.ms_categorias.excepciones.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements ICategoriaService {

    private final CategoriaRepository repository;

    @Override
    public List<Categoria> obtenerTodas() {
        return repository.findAll();
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public Categoria buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        Categoria cat = buscarPorId(id);
        repository.delete(cat);
    }
}