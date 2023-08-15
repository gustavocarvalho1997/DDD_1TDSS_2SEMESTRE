package br.com.fiap.collection.exercicio02.view;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		int qtdNumeros = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de números a serem registrados: "));
		ArrayList<Integer> numeros = new ArrayList<>();
		
		for(int i = 0; i < qtdNumeros; i++) {
			int numero = Integer.parseInt(JOptionPane.showInputDialog("Informe o número a ser adicionado: "));
			numeros.add(numero);
		}
		
		Collections.sort(numeros, Collections.reverseOrder());
		
		System.out.println(numeros.get(0));
	}// MAIN
}// CLASS