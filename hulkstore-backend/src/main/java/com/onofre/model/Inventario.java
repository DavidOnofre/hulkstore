package com.onofre.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInventario;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "total", nullable = false)
	private Integer total;

	@ManyToOne
	@JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_inventario_producto"))
	private Producto producto;

}
