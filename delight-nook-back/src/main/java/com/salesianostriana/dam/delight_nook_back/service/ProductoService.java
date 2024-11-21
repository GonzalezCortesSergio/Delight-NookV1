package com.salesianostriana.dam.delight_nook_back.service;

import com.salesianostriana.dam.delight_nook_back.model.Producto;
import com.salesianostriana.dam.delight_nook_back.model.Resenia;
import com.salesianostriana.dam.delight_nook_back.repository.ProductoRepository;
import com.salesianostriana.dam.delight_nook_back.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService extends BaseServiceImpl<Producto, Long, ProductoRepository> {

    @Autowired
    private ReseniaService reseniaService;

    public Producto edit(Producto p, Long id){

        Optional<Producto> optionalProducto = repository.findById(id);

        if(optionalProducto.isEmpty())
            return null;

        Producto antiguo = optionalProducto.get();

        antiguo.setNombreProducto(p.getNombreProducto());
        antiguo.setPrecio(p.getPrecio());
        antiguo.setPhotoUrl(p.getPhotoUrl());

        return repository.save(antiguo);
    }

    public Producto addResenia(Resenia r, Long idProducto) {

        Optional<Producto> optionalProducto = repository.findById(idProducto);

        if (optionalProducto.isEmpty())
            return null;

        Producto producto = optionalProducto.get();

        producto.addResenia(r);

        reseniaService.save(r);

        return repository.save(producto);
    }

    public Producto removeResenia(Long idResenia, Long idProducto) {

        Optional<Producto> optionalProducto = repository.findById(idProducto);

        Optional<Resenia> optionalResenia = reseniaService.findById(idResenia);
        if(optionalProducto.isEmpty() || optionalResenia.isEmpty())
            return null;

        Producto producto = optionalProducto.get();

        Resenia resenia = optionalResenia.get();

        producto.removeResenia(resenia);

        reseniaService.delete(resenia);

        return repository.save(producto);
    }
}
