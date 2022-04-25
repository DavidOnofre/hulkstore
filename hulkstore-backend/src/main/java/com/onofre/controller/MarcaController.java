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
import com.onofre.model.Marca;
import com.onofre.service.IMarcaService;

@RestController
@RequestMapping("marcas")
public class MarcaController {

	@Autowired
	private IMarcaService service;

	/**
	 * listar todos
	 * @return
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Marca>> listar() throws Exception {
		List<Marca> lista = service.listar();
		return new ResponseEntity<List<Marca>>(lista, HttpStatus.OK);
	}

	/**
	 * listar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Marca> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Marca obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		return new ResponseEntity<Marca>(obj, HttpStatus.OK);
	}

	/**
	 * Registrar un Marca
	 * @param Marca
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody Marca Marca) throws Exception {
		Marca obj = service.registrar(Marca);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdMarca()).toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Modifica un Marca
	 * @param Marca
	 * @return
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Marca> modificar(@Valid @RequestBody Marca Marca) throws Exception {
		Marca obj = service.modificar(Marca);
		return new ResponseEntity<Marca>(obj, HttpStatus.OK);
	}

	/**
	 * Eliminar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Marca obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
