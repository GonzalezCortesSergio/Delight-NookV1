import { Component, Input } from '@angular/core';
import { Producto } from '../../models/interfaces/producto.interface';

@Component({
  selector: 'app-producto-card',
  templateUrl: './producto-card.component.html',
  styleUrl: './producto-card.component.css'
})
export class ProductoCardComponent {

  @Input()
  producto!: Producto;
}
