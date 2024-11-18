package com.salesianostriana.dam.delight_nook_back.repository;

import com.salesianostriana.dam.delight_nook_back.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
