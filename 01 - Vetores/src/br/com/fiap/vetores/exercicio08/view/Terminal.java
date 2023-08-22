package br.com.fiap.vetores.exercicio08.view;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		char letras[] = new char[30];
		for(int i = 0; i < letras.length; i++) {
			char letra = JOptionPane.showInputDialog("Informe uma letra: ").charAt(0);
			letras[i] = letra;
		}
		
		char letrasCopia[] = new char[30];
		System.arraycopy(letras, 0, letrasCopia, 0, letrasCopia.length);
		
		for(int i = 0; i < letras.length; i++) {
			int temp = 0;
			for(int j = 0; j < letrasCopia.length; j++) {
				if(letras[i] == letrasCopia[j]) {
					temp += 1;
				}
			}// Inner for
			if(temp <= 1) {
				System.out.println(letras[i] + " não se repete");
			} else {
				System.out.println(letras[i] + " se repete " + (temp - 1) + " vezes!");
			}
		}// Outter for
		
		
		
	}// MAIN
}// CLASS