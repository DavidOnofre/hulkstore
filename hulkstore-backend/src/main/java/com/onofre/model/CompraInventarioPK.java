package com.onofre.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompraInventarioPK implements Serializable {

	private static final long serialVersionUID = -8453522719949060941L;

	@ManyToOne
	@JoinColumn(name = "idCompra", nullable = false)
	private Compra compra;

	@ManyToOne
	@JoinColumn(name = "idInventario", nullable = false)
	private Inventario inventario;

}
