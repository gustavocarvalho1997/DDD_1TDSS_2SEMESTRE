package br.com.fiap.collection.exercicio03.view;

import java.util.ArrayList;
import java.util.Collections;

import br.com.fiap.collection.exercicio03.classes.*;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		int qtdAlunos = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de alunos a serem cadastrados: "));
		ArrayList<Aluno> aluno = new ArrayList<>();
		
		for(int i = 0; i < qtdAlunos; i++) {
			String nome = JOptionPane.showInputDialog("Informe o nome do aluno:");
			double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a primeira nota:"));
			double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a segunda nota:"));
			double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Informe a terceira nota:"));
			ArrayList<Double> arrNotas= new ArrayList<>();
			arrNotas.add(nota1);
			arrNotas.add(nota2);
			arrNotas.add(nota3);
			
			aluno.add(new Aluno(nome, arrNotas));
		}// for
		
		ArrayList<Double> arrNotasGerais = new ArrayList<>();
		for(int i = 0 ; i < aluno.size() ; i++) {
			double nota = aluno.get(i).retornaMaiorNota();
			arrNotasGerais.add(nota);
		}
		
		Collections.sort(arrNotasGerais, Collections.reverseOrder());
		double maiorNota = arrNotasGerais.get(0);
		
		for(int i = 0; i < aluno.size(); i++) {
			if(aluno.get(i).retornaMaiorNota() == maiorNota) {
				System.out.println(aluno.get(i).getNome() + " obteve a maior nota com : " + maiorNota);
			}
		}
		
	}// MAIN
}// CLASS