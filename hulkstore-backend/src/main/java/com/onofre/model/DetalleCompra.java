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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "detalleCompra")
public class DetalleCompra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetalleCompra;

	@Column(name = "cantidad", nullable = false)
	private Integer cantidad;

	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal;

	@Column(name = "total", nullable = false)
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "FK_detCompra_producto"))
	private Producto producto;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "idCompra", nullable = false, foreignKey = @ForeignKey(name = "FK_detCompra_compra"))
	private Compra compra;

}
