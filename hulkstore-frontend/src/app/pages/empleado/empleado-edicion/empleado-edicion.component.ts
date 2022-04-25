import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { EmpleadoService } from 'src/app/_service/empleado.service';

@Component({
  selector: 'app-empleado-edicion',
  templateUrl: './empleado-edicion.component.html',
  styleUrls: ['./empleado-edicion.component.css'],
})
export class EmpleadoEdicionComponent implements OnInit {
  form: FormGroup | undefined;
  id!: number;

  constructor(private route: ActivatedRoute, private empleadoService: EmpleadoService) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      id: new FormControl(0),
      nombres: new FormControl(''),
      apellidos: new FormControl(''),
      cedula: new FormControl(''),
      telefono: new FormControl(''),
    });

    this.route.params.subscribe((data: Params) => {
      this.id = data['id'];
      this.initForm();
    });
  }

  private initForm() {

      this.empleadoService.listarPorId(this.id).subscribe((data) => {
        this.form = new FormGroup({
          id: new FormControl(data.idEmpleado),
          nombres: new FormControl(data.nombres),
          apellidos: new FormControl(data.apellidos),
          cedula: new FormControl(data.cedula),
          telefono: new FormControl(data.telefono),
        });
      });

  }
}
