package com.salesianostriana.dam.delight_nook_back.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombreProducto;

    @Column(columnDefinition = "TEXT")
    private String photoUrl;

    @ManyToOne
    private TipoProducto tipoProducto;

    private Double precio;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "producto"
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Builder.Default
    private List<Resenia> resenia = new ArrayList<>();



    //Métodos HELPER

    public void addResenia(Resenia r) {

        this.resenia.add(r);
        r.setProducto(this);
    }

    public void removeResenia(Resenia r) {

        this.resenia.remove(r);
        r.setProducto(null);
    }
}
