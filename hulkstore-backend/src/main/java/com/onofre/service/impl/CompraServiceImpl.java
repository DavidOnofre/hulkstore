package com.onofre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onofre.dto.CompraListaInventarioDTO;
import com.onofre.exception.ModeloNotFoundException;
import com.onofre.model.Compra;
import com.onofre.model.Inventario;
import com.onofre.repo.ICompraInventarioRepo;
import com.onofre.repo.ICompraRepo;
import com.onofre.repo.IGenericRepo;
import com.onofre.repo.IInventarioRepo;
import com.onofre.service.ICompraService;

@Service
public class CompraServiceImpl extends CRUDImpl<Compra, Integer> implements ICompraService {

	@Autowired
	private ICompraRepo repo;

	@Autowired
	private ICompraInventarioRepo dCIrepo;

	@Autowired
	private IInventarioRepo inventarioRepo;

	@Override
	protected IGenericRepo<Compra, Integer> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Compra registrarTransaccional(CompraListaInventarioDTO dto) throws Exception {

		dto.getCompra().getDetalleCompra().forEach(det -> det.setCompra(dto.getCompra()));

		// compra, detalle compra
		repo.save(dto.getCompra());

		// compra - inventario
		dto.getLstInventario().forEach(inv -> dCIrepo.registrar(dto.getCompra().getIdCompra(), inv.getIdInventario()));

		// actualizar inventario, como se compra se resta la cantidad del inventario (-)
		dto.getCompra().getDetalleCompra().forEach(
				det -> inventarioRepo.actualizarInventario(-det.getCantidad(), det.getProducto().getIdProducto()));

		List<Inventario> list = dto.getLstInventario();
		for (Inventario inventario2 : list) {
			Inventario inventario = inventarioRepo.getById(inventario2.getIdInventario());
			if (inventario.getTotal() <= 0) {
				throw new ModeloNotFoundException(
						"No hay suficiente en stock, idProducto = " + inventario.getProducto().getIdProducto());
			}
		}

		return dto.getCompra();

	}

}