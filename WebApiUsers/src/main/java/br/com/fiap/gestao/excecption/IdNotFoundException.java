package br.com.fiap.gestao.excecption;

@SuppressWarnings("serial")
public class IdNotFoundException extends Exception{
	// Construtor
	public IdNotFoundException(String message) {
		super(message);
	}
}// CLASS