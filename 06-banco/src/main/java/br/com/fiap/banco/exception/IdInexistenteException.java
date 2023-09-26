package br.com.fiap.banco.exception;

public class IdInexistenteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdInexistenteException(String mensagem) {
		super(mensagem);
	}
}
