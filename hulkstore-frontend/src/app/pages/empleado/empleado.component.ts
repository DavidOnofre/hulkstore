import { Empleado } from './../../_model/empleado';
import { EmpleadoService } from './../../_service/empleado.service';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css'],
})
export class EmpleadoComponent implements OnInit {
  displayedColumns = [
    'idEmpleado',
    'nombres',
    'apellidos',
    'cedula',
    'telefono',
    'acciones',
  ];
  dataSource = new MatTableDataSource<Empleado>();

  empleados!: Empleado[];

  constructor(private empleadoService: EmpleadoService) {}

  ngOnInit(): void {
    this.empleadoService.listar().subscribe((data) => {
      this.dataSource = new MatTableDataSource(data);
    });
  }
}
