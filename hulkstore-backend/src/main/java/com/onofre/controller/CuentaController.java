package com.onofre.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.onofre.exception.ModeloNotFoundException;
import com.onofre.model.Cuenta;
import com.onofre.service.ICuentaService;

@RestController
@RequestMapping("cuentas")
public class CuentaController {

	@Autowired
	private ICuentaService service;

	/**
	 * listar todos
	 * @return
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Cuenta>> listar() throws Exception {
		List<Cuenta> lista = service.listar();
		return new ResponseEntity<List<Cuenta>>(lista, HttpStatus.OK);
	}

	/**
	 * listar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Cuenta> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Cuenta obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		return new ResponseEntity<Cuenta>(obj, HttpStatus.OK);
	}

	/**
	 * Registrar un Cuenta
	 * @param Cuenta
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Cuenta Cuenta) throws Exception {
		Cuenta obj = service.registrar(Cuenta);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCuenta()).toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Modifica un Cuenta
	 * @param Cuenta
	 * @return
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Cuenta> modificar(@Valid @RequestBody Cuenta Cuenta) throws Exception {
		Cuenta obj = service.modificar(Cuenta);
		return new ResponseEntity<Cuenta>(obj, HttpStatus.OK);
	}

	/**
	 * Eliminar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Cuenta obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
