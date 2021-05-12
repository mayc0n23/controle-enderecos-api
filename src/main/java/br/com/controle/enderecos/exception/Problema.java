package br.com.controle.enderecos.exception;

import java.time.LocalDateTime;

public class Problema {
	
	private LocalDateTime timestamp;
	
	private String mensagem;
	
	//gets e sets

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}