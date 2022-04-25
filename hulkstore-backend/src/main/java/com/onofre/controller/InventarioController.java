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
import com.onofre.model.Inventario;
import com.onofre.service.IInventarioService;

@RestController
@RequestMapping("inventarios")
public class InventarioController {

	@Autowired
	private IInventarioService service;

	/**
	 * listar todos
	 * @return
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Inventario>> listar() throws Exception {
		List<Inventario> lista = service.listar();
		return new ResponseEntity<List<Inventario>>(lista, HttpStatus.OK);
	}

	/**
	 * listar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Inventario> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Inventario obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		return new ResponseEntity<Inventario>(obj, HttpStatus.OK);
	}

	/**
	 * Registrar un Inventario
	 * @param Inventario
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Inventario Inventario) throws Exception {
		Inventario obj = service.registrar(Inventario);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdInventario()).toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Modifica un Inventario
	 * @param Inventario
	 * @return
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Inventario> modificar(@Valid @RequestBody Inventario Inventario) throws Exception {
		Inventario obj = service.modificar(Inventario);
		return new ResponseEntity<Inventario>(obj, HttpStatus.OK);
	}

	/**
	 * Eliminar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Inventario obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
