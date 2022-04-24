package com.onofre;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onofre.model.Cuenta;
import com.onofre.model.Empleado;
import com.onofre.repo.ICuentaRepo;

@SpringBootTest
class CuentaRepoTests {

	@Autowired
	private ICuentaRepo repo;

	@Test
	void grabarCuenta() {

		Cuenta cuenta = new Cuenta();
		cuenta.setNumeroCuenta("4771139123");
		cuenta.setTipoCuenta("COR");
		cuenta.setEstado(false);

		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1);

		cuenta.setEmpleado(empleado);

		Cuenta retorno = repo.save(cuenta);

		assertTrue(retorno.getIdCuenta() != null);

	}

	@Test
	void obtenerCuenta() {
		Integer idCuenta = 1;
		Cuenta retorno = repo.getById(idCuenta);
		assertTrue(retorno.getIdCuenta() != null);
	}

	@Test
	void modificarCuenta() {

		Cuenta cuenta = new Cuenta();
		cuenta.setIdCuenta(1);
		cuenta.setNumeroCuenta("4771139123");
		cuenta.setTipoCuenta("AHO");
		cuenta.setEstado(false);

		Empleado empleado = new Empleado();
		empleado.setIdEmpleado(1);

		cuenta.setEmpleado(empleado);

		Cuenta retorno = repo.save(cuenta);

		assertTrue(retorno.getIdCuenta() != null);

	}

	@Test
	void eliminarCuenta() {
		Integer idCuenta = 999;
		repo.deleteById(idCuenta);
		assertThatThrownBy(() -> repo.deleteById(idCuenta));
	}

}
