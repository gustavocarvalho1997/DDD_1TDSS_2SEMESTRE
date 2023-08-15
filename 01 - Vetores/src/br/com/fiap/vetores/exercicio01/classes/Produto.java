package br.com.fiap.vetores.exercicio01.classes;

public class Produto {
	//Atributos
	private int qtd;
	private float preco, descontoEmReais;
	//Construtor
	public Produto(int qtd, float preco, float descontoEmReais) {
		super();
		this.qtd = qtd;
		this.preco = preco;
		this.descontoEmReais = descontoEmReais;
	}
	
	//Getters
	public int getQtd() {
		return qtd;
	}


	public float getPreco() {
		return preco;
	}


	public float getDescontoEmReais() {
		return descontoEmReais;
	}

	//Setters
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public void setDescontoEmReais(float descontoEmReais) {
		this.descontoEmReais = descontoEmReais;
	}


	//Métodos
	public float retornarValorAPagar() {
		return (preco - descontoEmReais) * qtd;
	}
	
}//CLASS