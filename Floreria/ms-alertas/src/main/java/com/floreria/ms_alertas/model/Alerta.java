package com.floreria.ms_alertas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "alertas")
@Data
public class Alerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El mensaje de la alerta no puede estar vacío")
    private String mensaje;

    private String tipo; // "CRITICO", "INFO"
}