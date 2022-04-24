package com.onofre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEmpleado;

	@NotNull
	@Size(min = 3, max = 70, message = "Nombres debe estar entre 3 y 70 caracteres.")
	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@NotNull
	@Size(min = 3, max = 70, message = "Apellidos debe estar entre 3 y 70 caracteres.")
	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Size(min = 10, max = 10, message = "Cédula debe tener 10 caracteres")
	@Column(name = "cedula", nullable = false, length = 10)
	private String cedula;

	@Size(min = 10, max = 150, message = "Dirección debe tener maximo 150 caracteres")
	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;

	@Size(min = 10, max = 10, message = "Teléfono debe tener 10 caracteres")
	@Column(name = "telefono", nullable = false, length = 10)
	private String telefono;

	@Email
	@Column(name = "email", nullable = false, length = 55)
	private String email;

}
