package br.com.fiap.collection.exercicio08.view;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		ArrayList<Character> letras= new ArrayList<>();
		for(int i = 0; i < 30; i++) {
			char letra = JOptionPane.showInputDialog("Informe uma letra: ").charAt(0);
			letras.add(letra);
		}
		
		ArrayList<Character> letrasCopia = new ArrayList<>();
		letrasCopia.addAll(letras);
		
		for(int i = 0; i < letras.size(); i++) {
			int temp = 0;
			for(int j = 0; j < letrasCopia.size(); j++) {
				if(letras.get(i) == letrasCopia.get(j)) {
					temp += 1;
				}
			}// Inner for
			if(temp <= 1) {
				System.out.println(letras.get(i) + " não se repete");
			} else {
				System.out.println(letras.get(i) + " se repete " + (temp - 1) + " vezes!");
			}
		}// Outter for
		
		
		
	}// MAIN
}// CLASS