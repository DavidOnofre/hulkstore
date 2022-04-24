package com.onofre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "cuenta")
public class Cuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCuenta;

	@NotNull
	@Size(min = 10, max = 10, message = "Número de cuenta debe tener 10 dígitos.")
	@Column(name = "numero_cuenta", nullable = false, length = 10)
	private String numeroCuenta;

	@Size(min = 3, max = 3, message = "Tipos permitidos AHO, CTE")
	@Column(name = "tipo_cuenta", nullable = false, length = 3)
	private String tipoCuenta;

	@Column(name = "estado", nullable = false)
	private boolean estado;

	@ManyToOne
	@JoinColumn(name = "idEmpleado", nullable = false, foreignKey = @ForeignKey(name = "FK_cuenta_empleado"))
	private Empleado empleado;

}
