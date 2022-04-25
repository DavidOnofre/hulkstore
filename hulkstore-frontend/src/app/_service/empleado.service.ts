import { environment } from './../../environments/environment';
import { Empleado } from './../_model/empleado';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class EmpleadoService {
  private url: string = `${environment.HOST}/empleados`;

  constructor(private http: HttpClient) {}

  listar() {
    return this.http.get<Empleado[]>(this.url);
  }

  listarPorId(id: number) {
    return this.http.get<Empleado>(`${this.url}/${id}`);
  }
}
