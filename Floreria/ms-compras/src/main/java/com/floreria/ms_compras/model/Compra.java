package com.floreria.ms_compras.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "compras")
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El ID del proveedor es requerido")
    private Long proveedorId;

    @NotNull(message = "El monto total es requerido")
    private Double total;
}