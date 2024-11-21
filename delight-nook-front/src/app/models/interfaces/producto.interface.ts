import { Resenia } from "./resenia.interface";
import { TipoProducto } from "./tipo-producto.interface";

export interface Producto {

    id: number;
    nombreProducto: string;
    photoUrl: string;
    tipoProducto: TipoProducto;
    precio: number;
    resenias: Resenia[];
}