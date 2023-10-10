package br.com.fiap.banco.model;

public class Conta {
	//Atributos
	private int id;
	private String numero, nomeTitular, cpf;
	private double saldo;
	private boolean ativo;
	//Construtores
	public Conta(int id, String numero, String nomeTitular, String cpf, double saldo, boolean ativo) {
		super();
		this.id = id;
		this.numero = numero;
		this.nomeTitular = nomeTitular;
		this.cpf = cpf;
		this.saldo = saldo;
		this.ativo = ativo;
	}//Conta
	public Conta(String numero, String nomeTitular, String cpf, double saldo, boolean ativo) {
		super();
		this.numero = numero;
		this.nomeTitular = nomeTitular;
		this.cpf = cpf;
		this.saldo = saldo;
		this.ativo = ativo;
	}//Conta
	//Getters
	public int getId() {
		return id;
	}
	public String getNumero() {
		return numero;
	}
	public String getNomeTitular() {
		return nomeTitular;
	}
	public String getCpf() {
		return cpf;
	}
	public double getSaldo() {
		return saldo;
	}
	public boolean isAtivo() {
		return ativo;
	}
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	//toString
	@Override
	public String toString() {
		return "Conta [id = " + id + ", numero = " + numero + ", nomeTitular = " + nomeTitular + "]";
	}
	//Métodos
	public void sacar(Double valor) {
		saldo -= valor;
	}
	public void depositar(Double valor) {
		saldo += valor;
	}
	
	
}//CLASS