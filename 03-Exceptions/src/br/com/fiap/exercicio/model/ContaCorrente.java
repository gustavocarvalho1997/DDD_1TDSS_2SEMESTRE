package br.com.fiap.exercicio.model;

public class ContaCorrente {
	// Atributos
	private double saldo, limite;
	// Construtores
	public ContaCorrente() {
		super();
	}
	public ContaCorrente(double saldo, double limite) {
		super();
		this.saldo = saldo;
		this.limite = limite;
	}
	// Getters
	public double getSaldo() {
		return saldo;
	}

	public double getLimite() {
		return limite;
	}
	// Setters
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void setLimite(double limite) throws Exception{
		if(limite < 0) {
			throw new Exception("Limite deve ser maior do que zero");
		}
		this.limite = limite;
	}
	// Métodos
	public void sacar(double valor) throws Exception{
		if(valor < 0) {
			throw new Exception("Valor deve ser maior do que zero");
		}
		if(valor > limite) {
			throw new Exception("Limite não permitido, valor máximo : " + limite);
		}
		saldo -= valor;
	}
	
	public void depositar(double valor) throws Exception{
		if(valor < 0) {
			throw new Exception("Valor deve ser maior do que zero");
		}
		saldo += valor;
	}
	
}// CLASS