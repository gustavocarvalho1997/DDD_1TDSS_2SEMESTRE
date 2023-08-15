package br.com.fiap.vetores.exercicio04.view;

import javax.swing.JOptionPane;
import br.com.fiap.vetores.exercicio04.classes.*;
public class Terminal {
	public static void main(String[] args) {
		int qtdEleitores = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de eleitores a serem avaliados:"));
		Eleitor[] eleitor = new Eleitor[qtdEleitores];
		
		for(int i = 0; i < qtdEleitores ; i++) {
			int idadeEleitor = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do " + (i+1) + "º eleitor:"));
			eleitor[i] = new Eleitor(idadeEleitor);
		}
		
		int qtdObrigatorios = 0;
		
		for(int i = 0; i < eleitor.length ; i++) {
			boolean statusObrigatoriedade = eleitor[i].retornarObrigatoriedade();
			if(statusObrigatoriedade) {
				qtdObrigatorios += 1;
			}
		}
		
		System.out.println("Temos um total de " + qtdObrigatorios + " eleitores obrigatórios!");
		
	}//MAIN
}//CLASS