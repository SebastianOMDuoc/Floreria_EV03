package com.floreria.ms_proveedores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "proveedores")
@Data
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del proveedor es obligatorio")
    private String nombre;

    @NotBlank(message = "El teléfono de contacto es obligatorio")
    private String telefono;
}