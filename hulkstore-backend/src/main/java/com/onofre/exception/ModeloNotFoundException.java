package com.onofre.exception;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModeloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7854519934103787164L;

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}