package com.salesianostriana.dam.delight_nook_back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Resenia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idResenia;

    @Column(columnDefinition = "TEXT")
    private String comentario;

    private Integer puntuacion;

    @ManyToOne
    private Producto producto;
}
