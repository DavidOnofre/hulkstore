package com.onofre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onofre.model.Producto;
import com.onofre.repo.IGenericRepo;
import com.onofre.repo.IProductoRepo;
import com.onofre.service.IProductoService;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

	@Autowired
	private IProductoRepo repo;

	@Override
	protected IGenericRepo<Producto, Integer> getRepo() {
		return repo;
	}

}