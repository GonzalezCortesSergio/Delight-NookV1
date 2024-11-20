package com.salesianostriana.dam.delight_nook_back.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
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
