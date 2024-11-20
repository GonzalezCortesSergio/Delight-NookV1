package com.salesianostriana.dam.delight_nook_back.dto;

import com.salesianostriana.dam.delight_nook_back.model.TipoProducto;

public record GetTipoProductoDto(
        Long idTipo,
        String nombreTipo
) {

    public static GetTipoProductoDto of (TipoProducto tp) {

        return new GetTipoProductoDto(
                tp.getIdTipo(),
                tp.getNombreTipo()
        );
    }
}
