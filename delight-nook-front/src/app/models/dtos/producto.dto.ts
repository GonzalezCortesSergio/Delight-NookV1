import { TipoProducto } from "../interfaces/tipo-producto.interface";

export class ProductoDto {

    constructor(
        public nombreProducto: string,
        public tipoProducto: TipoProducto,
        public precio: number
    ){}
}