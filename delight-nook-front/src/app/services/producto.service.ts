import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Producto } from '../models/interfaces/producto.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  API_URL = "http://localhost:8080/api/productos";

  constructor(private http: HttpClient) { }


  getProductos(): Observable<Producto[]> {

    return this.http.get<Producto[]>(this.API_URL);
  }
}
