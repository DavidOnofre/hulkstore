import { EmpleadoEdicionComponent } from './pages/empleado/empleado-edicion/empleado-edicion.component';
import { BuscarComponent } from './pages/buscar/buscar.component';
import { CompraComponent } from './pages/compra/compra.component';
import { ProductoComponent } from './pages/producto/producto.component';
import { BodegaComponent } from './pages/bodega/bodega.component';
import { CuentaComponent } from './pages/cuenta/cuenta.component';
import { EmpleadoComponent } from './pages/empleado/empleado.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MarcaComponent } from './pages/marca/marca.component';

const routes: Routes = [
  {
    path: 'empleados',
    component: EmpleadoComponent,
    children: [
      { path: 'nuevo', component: EmpleadoEdicionComponent },
      { path: 'edicion/:id', component: EmpleadoEdicionComponent },
    ],
  },
  {
    path: 'marcas',
    component: MarcaComponent,
  },

  {
    path: 'cuentas',
    component: CuentaComponent,
  },

  {
    path: 'inventarios',
    component: BodegaComponent,
  },

  {
    path: 'productos',
    component: ProductoComponent,
  },

  {
    path: 'compras',
    component: CompraComponent,
  },

  {
    path: 'buscar',
    component: BuscarComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
