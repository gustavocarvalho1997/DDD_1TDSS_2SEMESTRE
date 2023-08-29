package br.com.fiap.collection.exercicio05.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		int qtdNumeros = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de números a serem inseridos: "));
		ArrayList<Double> numeros = new ArrayList<>();
		
		// Entrada de dados
		for(int i = 0; i < qtdNumeros; i++) {
			double numeroInformado = Double.parseDouble(JOptionPane.showInputDialog("Informe um número real: "));
			numeros.add(numeroInformado);
		}
		
		for(int i = (numeros.size() - 1); i >= 0 ; i--) {
			System.out.println(numeros.get(i));
		}
		
	}// MAIN
}// CLASS