package br.com.controle.enderecos.exception;

public class UsuarioNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UsuarioNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

}