package br.com.fiap.collection.exercicio04.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import br.com.fiap.collection.exercicio04.classes.*;
public class Terminal {
	public static void main(String[] args) {
		int qtdEleitores = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de eleitores a serem avaliados:"));
		ArrayList<Eleitor> eleitor = new ArrayList<>();
		
		for(int i = 0; i < qtdEleitores ; i++) {
			int idadeEleitor = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do " + (i+1) + "º eleitor:"));
			eleitor.add(new Eleitor(idadeEleitor));
		}
		
		int qtdObrigatorios = 0;
		
		for(Eleitor item : eleitor) {
			boolean statusObrigatoriedade = item.retornarObrigatoriedade();
			if(statusObrigatoriedade) {
				qtdObrigatorios += 1;
			}
		}
		
		System.out.println("Temos um total de " + qtdObrigatorios + " eleitores obrigatórios!");
		
	}//MAIN
}//CLASS