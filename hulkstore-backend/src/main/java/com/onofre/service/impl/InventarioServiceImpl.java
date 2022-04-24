package com.onofre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onofre.model.Inventario;
import com.onofre.repo.IGenericRepo;
import com.onofre.repo.IInventarioRepo;
import com.onofre.service.IInventarioService;

@Service
public class InventarioServiceImpl extends CRUDImpl<Inventario, Integer> implements IInventarioService {

	@Autowired
	private IInventarioRepo repo;

	@Override
	protected IGenericRepo<Inventario, Integer> getRepo() {
		return repo;
	}

}