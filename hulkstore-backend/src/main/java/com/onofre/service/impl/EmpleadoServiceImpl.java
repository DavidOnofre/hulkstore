package com.onofre.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onofre.model.Empleado;
import com.onofre.repo.IEmpleadoRepo;
import com.onofre.repo.IGenericRepo;
import com.onofre.service.IEmpleadoService;

@Service
public class EmpleadoServiceImpl extends CRUDImpl<Empleado, Integer> implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepo repo;

	@Override
	protected IGenericRepo<Empleado, Integer> getRepo() {
		return repo;
	}

}