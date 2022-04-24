package com.onofre.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "compra_inventario")
@IdClass(CompraInventarioPK.class)
public class CompraInventario {

	@Id
	private Compra compra;

	@Id
	private Inventario inventario;

}
