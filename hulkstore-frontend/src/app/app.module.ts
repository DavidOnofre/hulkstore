import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { EmpleadoComponent } from './pages/empleado/empleado.component';
import { HttpClientModule } from '@angular/common/http';
import { MaterialModule } from './material/material.module';
import { MarcaComponent } from './pages/marca/marca.component';
import { CuentaComponent } from './pages/cuenta/cuenta.component';
import { BodegaComponent } from './pages/bodega/bodega.component';
import { ProductoComponent } from './pages/producto/producto.component';
import { CompraComponent } from './pages/compra/compra.component';
import { BuscarComponent } from './pages/buscar/buscar.component';
import { EmpleadoEdicionComponent } from './pages/empleado/empleado-edicion/empleado-edicion.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    EmpleadoComponent,
    MarcaComponent,
    CuentaComponent,
    BodegaComponent,
    ProductoComponent,
    CompraComponent,
    BuscarComponent,
    EmpleadoEdicionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MaterialModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
