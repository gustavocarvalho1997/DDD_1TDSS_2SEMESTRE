package br.com.fiap.vetores.exercicio05.view;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		int qtdNumeros = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de números a serem inseridos: "));
		double[] numeros = new double[qtdNumeros];
		
		// Entrada de dados
		for(int i = 0; i < numeros.length; i++) {
			double numeroInformado = Double.parseDouble(JOptionPane.showInputDialog("Informe um número real: "));
			numeros[i] = numeroInformado;
		}
		
		for(int i = (numeros.length - 1); i >= 0 ; i--) {
			System.out.println(numeros[i]);
		}
		
	}// MAIN
}// CLASS