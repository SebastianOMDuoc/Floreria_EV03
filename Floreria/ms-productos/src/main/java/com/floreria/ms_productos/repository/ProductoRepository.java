package com.floreria.ms_productos.repository;

import com.floreria.ms_productos.model.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {

    List<Producto> findAll(); //para listar los productos
    List<Producto> findByNombre(String nombre); //para encontrar un producto por su nombre
}