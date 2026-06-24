package com.floreria.ms_ventas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "ventas")
@Data
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del producto es mandatorio")
    private Long productoId;

    @NotNull(message = "La cantidad vendida es obligatoria")
    @Min(value = 1, message = "Debe vender al menos 1 unidad")
    private Integer cantidad;

    private Double totalCalculado;
}