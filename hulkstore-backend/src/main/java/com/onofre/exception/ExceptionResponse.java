package com.onofre.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionResponse {

	private LocalDateTime fecha;
	private String mensaje;
	private String detalles;

	public ExceptionResponse(LocalDateTime fecha, String mensaje, String detalles) {
		super();
		this.fecha = fecha;
		this.mensaje = mensaje;
		this.detalles = detalles;
	}

}