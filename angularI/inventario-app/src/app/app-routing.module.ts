import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgregarProductoComponent} from './agregar-producto/agregar-producto.component';
import { ProductoListaComponent } from './producto-lista/producto-lista.component';

//http://localhost:4200/productos
const routes: Routes = [
  {path:'productos', component:ProductoListaComponent},
  {path:'',redirectTo:'productos', pathMatch:'full'},
  {path:'agregar-producto', component: AgregarProductoComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
