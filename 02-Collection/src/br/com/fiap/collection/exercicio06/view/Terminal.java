package br.com.fiap.collection.exercicio06.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		int qtdNumeros = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de números ímpares a serem apresentados: "));
		ArrayList<Short> numerosImpares = new ArrayList<>();
		short impares = 1;
		
		for(int i = 0; i < qtdNumeros ; i++) {
			numerosImpares.add(impares);
			impares += 2;
		}
		
		for(int i = 0; i < numerosImpares.size(); i++) {
			System.out.println(numerosImpares.get(i));
		}
		
	}// MAIN
}// CLASS