import { Component } from '@angular/core';
import { Producto } from '../producto';
import { ProductoService } from '../producto.service';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.component.html'
})
export class ProductoListaComponent {

  productos: Producto[];

  constructor(private productoServicio: ProductoService){ }

    ngOnInit(){
      //Cargamos los productos
      this.obtenerProductos();
    }

    private obtenerProductos(){

      //consumir los datos del observable (suscribirnos  )
      this.productoServicio.obtenerProductosListas().subscribe(
        (datos =>{
          this.productos=datos;
          
        } )
      );

    }
  
}
