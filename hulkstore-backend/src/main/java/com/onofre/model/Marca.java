package com.onofre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "marca")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMarca;

	@NotNull
	@Size(min = 2, max = 20, message = "Nombre debe estar entre 3 y 20 caracteres.")
	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;

	@Size(min = 10, max = 150, message = "Descripción estar entre 10 y 150 caracteres.")
	@Column(name = "descripcion", nullable = false, length = 150)
	private String descripcion;

}
