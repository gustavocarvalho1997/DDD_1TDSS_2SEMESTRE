package br.com.fiap.vetores.exercicio07.view;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		double numeros[] = new double[16];
		
		
		for(int i = 0; i < numeros.length; i++) {
			double numeroInformado = Double.parseDouble(JOptionPane.showInputDialog("Informe o número desejado: "));
			numeros[i] = numeroInformado;
		}
		double arr1[] = Arrays.copyOfRange(numeros, 0, 8);
		double arr2[] = Arrays.copyOfRange(numeros, 8, 16);
		
		double numerosReposicionados[] = new double[arr1.length + arr2.length];
		int local = 8;
		System.arraycopy(arr2, 0, numerosReposicionados, 0, arr2.length);
		System.arraycopy(arr1, 0, numerosReposicionados, local, arr1.length);
		
		for(int i = 0; i < numerosReposicionados.length; i++) {
			System.out.println(numerosReposicionados[i]);
		}
		
		
	}// MAIN
}// CLASS