package com.floreria.ms_clientes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El RUT es obligatorio")
    private String rut;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
}