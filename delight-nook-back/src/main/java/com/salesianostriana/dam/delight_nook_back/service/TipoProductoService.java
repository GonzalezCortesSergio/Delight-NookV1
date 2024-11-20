package com.salesianostriana.dam.delight_nook_back.service;

import com.salesianostriana.dam.delight_nook_back.model.TipoProducto;
import com.salesianostriana.dam.delight_nook_back.repository.TipoProductoRepository;
import com.salesianostriana.dam.delight_nook_back.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoProductoService extends BaseServiceImpl<TipoProducto, Long, TipoProductoRepository> {


    public TipoProducto edit(TipoProducto tp, Long id) {

        Optional<TipoProducto> optionalTipoProducto = repository.findById(id);

        if (optionalTipoProducto.isEmpty())
            return null;

        TipoProducto antiguo = optionalTipoProducto.get();

        antiguo.setNombreTipo(tp.getNombreTipo());

        return antiguo;
    }
}
