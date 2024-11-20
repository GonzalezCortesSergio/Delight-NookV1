package com.salesianostriana.dam.delight_nook_back.controller;

import com.salesianostriana.dam.delight_nook_back.dto.GetProductoDto;
import com.salesianostriana.dam.delight_nook_back.model.Producto;
import com.salesianostriana.dam.delight_nook_back.model.Resenia;
import com.salesianostriana.dam.delight_nook_back.service.ProductoService;
import com.salesianostriana.dam.delight_nook_back.service.ReseniaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/productos")
@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;
    private final ReseniaService reseniaService;

    @GetMapping
    public ResponseEntity<List<GetProductoDto>> mostrarTodos() {

        if(productoService.findAll().isEmpty())
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);

        List<Producto> response = productoService.findAll();

        List<GetProductoDto> data = response.stream().map(GetProductoDto::of).toList();

        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> mostrarUno(@PathVariable Long id) {

        Optional<Producto> optionalProducto = productoService.findById(id);

        return optionalProducto.map(producto -> new ResponseEntity<>(producto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT));

    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto p) {

        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> editar(@RequestBody Producto p, @PathVariable Long id) {

        Producto aEditar = productoService.edit(p, id);

        if (aEditar == null)
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);

        return new ResponseEntity<>(aEditar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {

        Optional<Producto> optionalProducto = productoService.findById(id);

        if(optionalProducto.isEmpty())
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);

        productoService.delete(optionalProducto.get());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/resenia/add")
    public ResponseEntity<Producto> agregarResenia(@RequestBody Resenia resenia, @PathVariable Long idProducto) {

        Producto producto = productoService.addResenia(resenia, idProducto);

        if(producto == null){

            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    @PutMapping("/{idProducto}/resenia/{idResenia}/remove")
    public ResponseEntity<Producto> borrarResenia(@PathVariable("idProducto")Long idProducto, @PathVariable("idResenia")Long idResenia) {

        Producto producto = productoService.removeResenia(idResenia, idProducto);

        if (producto == null)
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);

        return new ResponseEntity<>(producto, HttpStatus.OK);
    }
}