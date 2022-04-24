package com.onofre.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> manejarTodasExceptiones(Exception ex, WebRequest request) {

		LocalDateTime fechaActual = LocalDateTime.now();
		String msj = ex.getMessage();
		String reqDes = request.getDescription(false);
		ExceptionResponse er = new ExceptionResponse(fechaActual, msj, reqDes);

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ModeloNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> manejarModeloNotFoundException(ModeloNotFoundException ex,
			WebRequest request) {

		LocalDateTime fechaActual = LocalDateTime.now();
		String msj = ex.getMessage();
		String reqDes = request.getDescription(false);
		ExceptionResponse er = new ExceptionResponse(fechaActual, msj, reqDes);

		return new ResponseEntity<ExceptionResponse>(er, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		LocalDateTime fechaActual = LocalDateTime.now();
		String mensaje = ex.getBindingResult().getAllErrors().stream().map(e -> {
			return e.getDefaultMessage().toString().concat(", ");
		}).collect(Collectors.joining());

		String reqDes = request.getDescription(false);
		ExceptionResponse er = new ExceptionResponse(fechaActual, mensaje, reqDes);

		return new ResponseEntity<Object>(er, HttpStatus.BAD_REQUEST);
	}

}
