package com.onofre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onofre.model.Marca;
import com.onofre.repo.IGenericRepo;
import com.onofre.repo.IMarcaRepo;
import com.onofre.service.IMarcaService;

@Service
public class MarcaServiceImpl extends CRUDImpl<Marca, Integer> implements IMarcaService {

	@Autowired
	private IMarcaRepo repo;

	@Override
	protected IGenericRepo<Marca, Integer> getRepo() {
		return repo;
	}

}