package br.com.fiap.vetores.exercicio02.view;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		int[] numeros = new int[Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de números que deseja inserir:"))];
		for(int i = 0; i<numeros.length; i++) {
			numeros[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe o número:" ));
		}
		
		Arrays.sort(numeros);
		
		for(int i = 0; i<numeros.length; i++) {
			System.out.println(numeros[i]);
		}
		
	}//MAIN
}//CLASS