package com.floreria.ms_empleados.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
@Data
public class Empleado{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del empleado es obligatorio")
    private String nombre;

    @NotBlank(message = "El cargo es obligatorio (ej: Florista, Repartidor)")
    private String cargo;
}