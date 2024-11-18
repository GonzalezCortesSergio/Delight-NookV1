package com.salesianostriana.dam.delight_nook_back.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTipo;

    private String nombreTipo;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "tipoProducto"
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Producto> listaProductos = new ArrayList<>();
}
