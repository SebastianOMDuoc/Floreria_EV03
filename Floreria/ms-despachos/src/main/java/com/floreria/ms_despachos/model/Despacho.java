package com.floreria.ms_despachos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "despachos")
@Data
public class Despacho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long ventaId;

    @NotBlank(message = "La dirección de destino es obligatoria")
    private String direccion;

    private String estado; // "PENDIENTE", "ENTREGADO"
}