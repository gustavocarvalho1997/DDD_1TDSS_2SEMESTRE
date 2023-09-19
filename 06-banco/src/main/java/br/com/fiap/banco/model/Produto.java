package br.com.fiap.banco.model;

public class Produto {
	//ATRIBUTOS
	private int codigo, numeroEstoque;
	private String nome;
	private double valorVenda, valorCompra;
	//CONSTRUTORES
	public Produto(int codigo, int numeroEstoque, String nome, double valorVenda, double valorCompra) {
		super();
		this.codigo = codigo;
		this.numeroEstoque = numeroEstoque;
		this.nome = nome;
		this.valorVenda = valorVenda;
		this.valorCompra = valorCompra;
	}
	public Produto() {
		super();
	}
	//GETTERS
	public int getCodigo() {
		return codigo;
	}
	public int getNumeroEstoque() {
		return numeroEstoque;
	}
	public String getNome() {
		return nome;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	//SETTERS
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNumeroEstoque(int numeroEstoque) {
		this.numeroEstoque = numeroEstoque;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	
}//CLASS