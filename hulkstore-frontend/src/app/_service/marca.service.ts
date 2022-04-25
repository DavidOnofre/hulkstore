import { Injectable } from '@angular/core';
import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Marca } from '../_model/marca';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {
  private url: string = `${environment.HOST}/marcas`;
  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<Marca[]>(this.url);
  }
}
