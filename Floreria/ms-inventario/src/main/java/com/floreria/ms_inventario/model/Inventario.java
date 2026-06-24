package com.floreria.ms_inventario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "inventarios")
@Data
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del producto es obligatorio")
    private Long productoId;

    @NotBlank(message = "La ubicación en bodega es obligatoria")
    private String ubicacionBodega; // Ej: "Pasillo A - Estante 2"
}