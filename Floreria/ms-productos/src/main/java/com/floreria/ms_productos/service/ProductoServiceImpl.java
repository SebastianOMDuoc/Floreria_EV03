package com.floreria.ms_productos.service;

import com.floreria.ms_productos.exception.ResourceNotFoundException;
import com.floreria.ms_productos.model.Producto;
import com.floreria.ms_productos.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    private final ProductoRepository repository;

    @Override
    public List<Producto> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Producto guardar(Producto producto) {
        return repository.save(producto);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con el ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se puede eliminar. Producto no encontrado con ID: " + id));
        repository.delete(producto);
    }

    @Override
    public Producto actualizar(Long id, Producto productoDetalles) {
        Producto producto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se puede actualizar. Producto no encontrado con ID: " + id));

        producto.setNombre(productoDetalles.getNombre());
        producto.setPrecio(productoDetalles.getPrecio());
        producto.setStock(productoDetalles.getStock());
        return repository.save(producto);
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }
}