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
import com.onofre.model.Empleado;
import com.onofre.service.IEmpleadoService;

@RestController
@RequestMapping("empleados")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService service;

	/**
	 * listar todos
	 * @return
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Empleado>> listar() throws Exception {
		List<Empleado> lista = service.listar();
		return new ResponseEntity<List<Empleado>>(lista, HttpStatus.OK);
	}

	/**
	 * listar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Empleado obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}

	/**
	 * Registrar un empleado
	 * @param Empleado
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Empleado Empleado) throws Exception {
		Empleado obj = service.registrar(Empleado);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdEmpleado()).toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Modifica un empleado
	 * @param Empleado
	 * @return
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Empleado> modificar(@Valid @RequestBody Empleado Empleado) throws Exception {
		Empleado obj = service.modificar(Empleado);
		return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
	}

	/**
	 * Eliminar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Empleado obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
