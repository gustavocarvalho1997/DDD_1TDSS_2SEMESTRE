package br.com.fiap.exceptions.model;

public class Produto {
	// Atributos 
	private String nome;
	private double preco;
	// Contrutor
	public Produto(String nome, double preco) {
		super();
		this.nome = nome;
		this.preco = preco;
	}
	// Getters
	public String getNome() {
		return nome;
	}
	public double getPreco() {
		return preco;
	}
	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	// Métodos
	// Retornar o valor do imposto do produto
	public double calcularImposto(double imposto) {
		// Se o imposto for menor do que 0, lançar uma RuntimeException
		if(imposto < 0) {
			throw new RuntimeException("Valor de imposto inválido");
		} else {
			return preco*(imposto/100);
		}
	}
	// Retornar o valor total dos produtos de acordo com a quantidade
	public double calcularValorTotal(int quantidade) {
		// Se a quantidade for menor ou igual a zero, lançar uma RuntimeException
		if(quantidade <= 0) {
			throw new RuntimeException("Quantidade inválida!");
		} else {
			return preco*quantidade;
		}
	}
	// NÃO ESQUECER DE CRIAM UM MAIN PARA TESTAR O LANÇAMENTO DE EXCEÇÕES
}// CLASS