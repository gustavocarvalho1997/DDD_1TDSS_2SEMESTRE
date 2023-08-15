package br.com.fiap.vetores.exercicio03.view;
import java.util.Arrays;

import javax.swing.JOptionPane;

import br.com.fiap.vetores.exercicio03.classes.*;
public class Terminal {
	public static void main(String[] args) {
		int qtdAlunos = Integer.parseInt(JOptionPane.showInputDialog("Informe o numero de alunos a serem cadastrados: "));
		Aluno[] aluno = new Aluno[qtdAlunos];
		
		for(int i = 0; i < qtdAlunos; i++) {
			String nome = JOptionPane.showInputDialog("Informe o nome do aluno:");
			double nota1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a primeira nota:"));
			double nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a segunda nota:"));
			double nota3 = Double.parseDouble(JOptionPane.showInputDialog("Informe a terceira nota:"));
			double arrNotas[] = new double[3];
			arrNotas[0] = nota1;
			arrNotas[1] = nota2;
			arrNotas[2] = nota3;
			
			aluno[i] = new Aluno(nome, arrNotas);
		}// for
		double arrNotasGerais[] = new double[aluno.length];
		for(int i = 0 ; i < aluno.length ; i++) {
			double nota = aluno[i].retornarMaiorNota();
			arrNotasGerais[i] = nota;
		}
		
		Arrays.sort(arrNotasGerais);
		
		double maiorNotaGeral = arrNotasGerais[arrNotasGerais.length-1];
		for(int i = 0; i < aluno.length; i++) {
			if(aluno[i].retornarMaiorNota() == maiorNotaGeral) {
				System.out.println(aluno[i].getNome() + " obteve a maior nota com : " + maiorNotaGeral);
			}
		}
		
	}// MAIN
}// CLASS