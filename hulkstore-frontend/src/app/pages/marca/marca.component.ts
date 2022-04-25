import { Marca } from './../../_model/marca';
import { Component, OnInit } from '@angular/core';
import { MarcaService } from 'src/app/_service/marca.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-marca',
  templateUrl: './marca.component.html',
  styleUrls: ['./marca.component.css'],
})
export class MarcaComponent implements OnInit {
  displayedColumns = ['idMarca', 'nombre', 'descripcion','acciones',];
  dataSource = new MatTableDataSource<Marca>();

  constructor(private marcaService: MarcaService) {}

  ngOnInit(): void {
    this.marcaService.listar().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }
}
