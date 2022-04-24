package com.onofre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onofre.model.Cuenta;
import com.onofre.repo.ICuentaRepo;
import com.onofre.repo.IGenericRepo;
import com.onofre.service.ICuentaService;

@Service
public class CuentaServiceImpl extends CRUDImpl<Cuenta, Integer> implements ICuentaService {

	@Autowired
	private ICuentaRepo repo;

	@Override
	protected IGenericRepo<Cuenta, Integer> getRepo() {
		return repo;
	}

}