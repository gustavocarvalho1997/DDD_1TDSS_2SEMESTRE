package br.com.fiap.banco.exception;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception{
	public AccountNotFoundException(String mensagem) {
		super(mensagem);
	}
}