package br.com.fiap.vetores.exercicio03.classes;

import java.util.Arrays;

public class Aluno {
	// Atributos
	private String nome;
	private double[] notas = new double[3];
	
	// Construtor
	public Aluno(String nome, double[] notas) {
		super();
		this.nome = nome;
		this.notas = notas;
	}
	
	// Getters
	public String getNome() {
		return nome;
	}

	public double[] getNotas() {
		return notas;
	}
	
	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setNotas(double[] notas) {
		this.notas = notas;
	}
	
	// Métodos
	public double retornarMaiorNota() {
		Arrays.sort(notas);
		return notas[2];
	}
	
	
}
