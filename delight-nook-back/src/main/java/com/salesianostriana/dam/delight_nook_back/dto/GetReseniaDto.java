package com.salesianostriana.dam.delight_nook_back.dto;

import com.salesianostriana.dam.delight_nook_back.model.Resenia;

public record GetReseniaDto(
        Long idResenia,
        String comentario,
        Integer puntuacion
) {

    public static GetReseniaDto of (Resenia resenia) {

        return new GetReseniaDto(
                resenia.getIdResenia(),
                resenia.getComentario(),
                resenia.getPuntuacion()
        );
    }
}
