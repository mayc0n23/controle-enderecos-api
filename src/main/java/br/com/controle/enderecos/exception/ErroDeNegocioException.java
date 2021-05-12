package br.com.controle.enderecos.exception;

public class ErroDeNegocioException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ErroDeNegocioException(String mensagem) {
		super(mensagem);
	}

}