package br.com.fiap.collection.exercicio01.classes;

public class Produto {
	// Atributos
	private int qtd;
	private float preco, descontoEmReais;
	// Construtor
	public Produto(int qtd, float preco, float descontoEmReais) {
		super();
		this.qtd = qtd;
		this.preco = preco;
		this.descontoEmReais = descontoEmReais;
	}
	
	// Getters
	public int getQtd() {
		return qtd;
	}
	public float getPrecos() {
		return preco;
	}
	public float getDescontoEmReais() {
		return descontoEmReais;
	}
	// Setters
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public void setPrecos(float precos) {
		this.preco = precos;
	}
	public void setDescontoEmReais(float descontoEmReais) {
		this.descontoEmReais = descontoEmReais;
	}
	// Métodos
	public float retornarValorTotal() {
		return (preco - descontoEmReais) * qtd;
	}
	
	
}//CLASS