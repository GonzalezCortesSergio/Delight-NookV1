package com.salesianostriana.dam.delight_nook_back.service;

import com.salesianostriana.dam.delight_nook_back.model.Resenia;
import com.salesianostriana.dam.delight_nook_back.repository.ReseniaRepository;
import com.salesianostriana.dam.delight_nook_back.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReseniaService extends BaseServiceImpl<Resenia, Long, ReseniaRepository> {

    public Resenia edit(Resenia r, Long id) {

        Optional<Resenia> optionalResenia = repository.findById(id);

        if (optionalResenia.isEmpty())
            return null;

        Resenia antigua = optionalResenia.get();

        antigua.setComentario(r.getComentario());
        antigua.setPuntuacion(r.getPuntuacion());

        return antigua;
    }
}
