import { Component, OnInit } from '@angular/core';
import { Producto } from '../../models/interfaces/producto.interface';
import { ProductoService } from '../../services/producto.service';

@Component({
  selector: 'app-producto-list',
  templateUrl: './producto-list.component.html',
  styleUrl: './producto-list.component.css'
})
export class ProductoListComponent implements OnInit{

  listaProductos: Producto[] = [];

  constructor(private productoService: ProductoService){}

  ngOnInit(): void {
      this.productoService.getProductos().subscribe(productos => {

        this.listaProductos = productos;
      })
  }
}
