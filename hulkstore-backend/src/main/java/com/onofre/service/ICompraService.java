package com.onofre.service;

import com.onofre.dto.CompraListaInventarioDTO;
import com.onofre.model.Compra;

public interface ICompraService extends ICRUD<Compra, Integer> {
	
	//Compra registrarTransaccional(Compra compra) throws Exception;
	Compra registrarTransaccional(CompraListaInventarioDTO dto) throws Exception;

}
