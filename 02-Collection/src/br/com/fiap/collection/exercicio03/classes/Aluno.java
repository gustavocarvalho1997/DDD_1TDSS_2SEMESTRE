package br.com.fiap.collection.exercicio03.classes;

import java.util.ArrayList;
import java.util.Collections;

public class Aluno {
	// Atributos
	private String nome;
	private ArrayList<Double> notas = new ArrayList<>();
	// Construtor
	public Aluno(String nome, ArrayList<Double> notas) {
		super();
		this.nome = nome;
		this.notas = notas;
	}
	
	// Getters
	public String getNome() {
		return nome;
	}
	public ArrayList<Double> getNotas() {
		return notas;
	}
	// Setters
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNotas(ArrayList<Double> notas) {
		this.notas = notas;
	}
	
	//Métodos
	public double retornaMaiorNota() {
		Collections.sort(notas, Collections.reverseOrder());
		return notas.get(0);
	}
	
	
	
}// CLASS