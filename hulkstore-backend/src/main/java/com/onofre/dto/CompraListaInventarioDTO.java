package com.onofre.dto;

import java.util.List;

import com.onofre.model.Compra;
import com.onofre.model.Inventario;

import lombok.Data;

@Data
public class CompraListaInventarioDTO {

	private Compra compra;
	private List<Inventario> lstInventario;

}
