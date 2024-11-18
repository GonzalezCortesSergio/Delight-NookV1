package com.salesianostriana.dam.delight_nook_back.service;

import com.salesianostriana.dam.delight_nook_back.model.Producto;
import com.salesianostriana.dam.delight_nook_back.repository.ProductoRepository;
import com.salesianostriana.dam.delight_nook_back.service.base.BaseServiceImpl;

import java.util.Optional;

public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository> {


    public Producto edit(Producto p, Long id){

        Optional<Producto> optionalProducto = repository.findById(id);

        if(optionalProducto.isEmpty())
            return null;

        Producto antiguo = optionalProducto.get();

        antiguo.setNombreProducto(p.getNombreProducto());
        antiguo.setPrecio(p.getPrecio());

        return antiguo;
    }
}
