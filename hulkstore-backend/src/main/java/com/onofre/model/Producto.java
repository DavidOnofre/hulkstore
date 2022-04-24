package com.onofre.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProducto;

	@NotNull
	@Size(min = 3, max = 20, message = "Nombre debe estar entre 3 y 20 caracteres.")
	@Column(name = "nombre", nullable = false, length = 20)
	private String nombre;

	@Size(min = 10, max = 150, message = "Descripción estar entre 10 y 150 caracteres.")
	@Column(name = "descripcion", nullable = false, length = 150)
	private String descripcion;

	@DecimalMin(value = "0.00", inclusive = true, message = "Mínimo valor permitido 0.00")
	@DecimalMax(value = "999.99", inclusive = true , message = "Máximo valor permitido 999.99")
	@Digits(integer = 3, fraction = 2 , message = "Formato aceptado para el precio 999.99")
	@Column(name = "precio", nullable = false)
	private BigDecimal precio;

	@ManyToOne
	@JoinColumn(name = "idMarca", nullable = false, foreignKey = @ForeignKey(name = "FK_producto_marca"))
	private Marca marca;

}
