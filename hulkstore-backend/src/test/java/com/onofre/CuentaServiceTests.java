package com.onofre;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onofre.model.Cuenta;
import com.onofre.model.Empleado;
import com.onofre.service.ICuentaService;

@SpringBootTest
class CuentaServiceTests {
		
	@Autowired
	private ICuentaService service;

	@Test
	void grabarCuenta() throws Exception {

		Cuenta cuenta = new Cuenta();
		cuenta.setNumeroCuenta("4771139123");
		cuenta.setTipoCuenta("COR");
		cuenta.setEstado(false);

		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1);

		cuenta.setEmpleado(empleado);

		Cuenta retorno = service.registrar(cuenta);

		assertTrue(retorno.getIdCuenta() != null);

	}
	
	@Test
	void obtenerCuenta() throws Exception {
		Integer idCuenta = 1;
		Cuenta retorno = service.listarPorId(idCuenta);
		assertTrue(retorno.getIdCuenta() != null);
	}
	
	@Test
	void modificarCuenta() throws Exception {

		Cuenta cuenta = new Cuenta();
		cuenta.setIdCuenta(1);
		cuenta.setNumeroCuenta("4771139123");
		cuenta.setTipoCuenta("AHO");
		cuenta.setEstado(false);

		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1);

		cuenta.setEmpleado(empleado);

		Cuenta retorno = service.modificar(cuenta);

		assertTrue(retorno.getIdCuenta() != null);

	}
	
	/*
	@Test
	void eliminarCuenta() throws Exception {
		Integer idCuenta = 28;
		service.eliminar(idCuenta);
		
		Cuenta retorno = service.listarPorId(idCuenta);
		assertTrue(retorno.getIdCuenta() == null);
	}*/
	
	@Test
	void eliminarCuenta() throws Exception {
		Integer idCuenta = 999;
		service.eliminar(idCuenta);
		assertThatThrownBy(() -> service.eliminar(idCuenta));
	}



	

}
