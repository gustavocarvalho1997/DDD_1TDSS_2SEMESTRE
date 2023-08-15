package br.com.fiap.vetores.exercicio04.classes;

public class Eleitor {
	// Atributos
	private int idade;
	private boolean obrigatorio;
	// Construtor
	public Eleitor(int idade) {
		super();
		this.idade = idade;
	}
	// Getters
	public int getIdade() {
		return idade;
	}
	public boolean isObrigatorio() {
		return obrigatorio;
	}
	// Setters
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setObrigatorio(boolean obrigatorio) {
		this.obrigatorio = obrigatorio;
	}
	// Métodos
	public boolean retornarObrigatoriedade() {
		if(idade >= 18 && idade <= 65) {
			setObrigatorio(true);
			return obrigatorio;
		} else {
			setObrigatorio(false);
			return obrigatorio;
		}
	}// retornarObrigatoriedade
}// CLASS