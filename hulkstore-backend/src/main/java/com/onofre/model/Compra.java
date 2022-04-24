package com.onofre.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCompra;

	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;

	@Column(name = "subtotal", nullable = false)
	private BigDecimal subtotal;

	@Column(name = "iva", nullable = false)
	private BigDecimal iva;

	@Column(name = "total", nullable = false)
	private BigDecimal total;

	@ManyToOne
	@JoinColumn(name = "idEmpleado", nullable = false, foreignKey = @ForeignKey(name = "FK_compra_empleado"))
	private Empleado empleado;

	@OneToMany(mappedBy = "compra", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<DetalleCompra> detalleCompra;

}
