package br.com.fiap.banco.exception;

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception{
	public InsufficientFundsException(String mensagem) {
		super(mensagem);
	}
}//CLASS