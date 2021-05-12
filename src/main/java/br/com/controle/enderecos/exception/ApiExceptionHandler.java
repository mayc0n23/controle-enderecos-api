package br.com.controle.enderecos.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<Object> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex, WebRequest request) {
		Problema problema = new Problema();
		problema.setMensagem(ex.getMessage());
		problema.setTimestamp(LocalDateTime.now());
		return handleExceptionInternal(ex, problema, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@ExceptionHandler(ErroDeNegocioException.class)
	public ResponseEntity<Object> handleErroDeNegocio(ErroDeNegocioException ex, WebRequest request) {
		Problema problema = new Problema();
		problema.setMensagem(ex.getMessage());
		problema.setTimestamp(LocalDateTime.now());
		return handleExceptionInternal(ex, problema, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
}