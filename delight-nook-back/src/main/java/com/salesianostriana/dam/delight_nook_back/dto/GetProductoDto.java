package com.salesianostriana.dam.delight_nook_back.dto;

import com.salesianostriana.dam.delight_nook_back.model.Producto;

import java.util.List;

public record GetProductoDto(
        Long id,
        String nombreProducto,
        GetTipoProductoDto tipoProducto,
        Double precio,
        List<GetReseniaDto> resenias
) {

    public static GetProductoDto of (Producto p) {

        return new GetProductoDto(
                p.getId(),
                p.getNombreProducto(),
                GetTipoProductoDto.of(p.getTipoProducto()),
                p.getPrecio(),
                p.getResenia().stream()
                        .map(GetReseniaDto::of).toList()
        );
    }
}
