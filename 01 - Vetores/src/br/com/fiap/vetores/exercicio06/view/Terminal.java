package br.com.fiap.vetores.exercicio06.view;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		int qtdNumeros = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de números ímpares a serem apresentados: "));
		short numerosImpares[] = new short[qtdNumeros];
		short impares = 1;
		
		for(int i = 0; i < numerosImpares.length ; i++) {
			numerosImpares[i] = impares;
			impares += 2;
		}
		
		for(int i = 0; i < numerosImpares.length; i++) {
			System.out.println(numerosImpares[i]);
		}
		
	}// MAIN
}// CLASS