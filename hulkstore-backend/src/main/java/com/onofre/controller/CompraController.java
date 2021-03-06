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

import com.onofre.dto.CompraListaInventarioDTO;
import com.onofre.exception.ModeloNotFoundException;
import com.onofre.model.Compra;
import com.onofre.service.ICompraService;

@RestController
@RequestMapping("compras")
public class CompraController {

	@Autowired
	private ICompraService service;

	/**
	 * listar todos
	 * @return
	 * @throws Exception
	 */
	@GetMapping
	public ResponseEntity<List<Compra>> listar() throws Exception {
		List<Compra> lista = service.listar();
		return new ResponseEntity<List<Compra>>(lista, HttpStatus.OK);
	}

	/**
	 * listar por id
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Compra> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Compra obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		return new ResponseEntity<Compra>(obj, HttpStatus.OK);
	}

	/**
	 * Registrar un Compra
	 * @param Compra
	 * @return
	 * @throws Exception
	 */
	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody CompraListaInventarioDTO dto) throws Exception {

		Compra obj = service.registrarTransaccional(dto);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getIdCompra()).toUri();

		return ResponseEntity.created(location).build();
	}

	/**
	 * Modifica un Compra
	 * @param Compra
	 * @return
	 * @throws Exception
	 */
	@PutMapping
	public ResponseEntity<Compra> modificar(@Valid @RequestBody Compra Compra) throws Exception {
		Compra obj = service.modificar(Compra);
		return new ResponseEntity<Compra>(obj, HttpStatus.OK);
	}

	/**
	 * Eliminar por id
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
		Compra obj = service.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		}

		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}
