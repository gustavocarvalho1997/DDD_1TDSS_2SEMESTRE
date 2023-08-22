package br.com.fiap.exceptions.view;

import javax.swing.JOptionPane;

public class Exemplo01 {
	public static void main(String[] args) {
		try {
			//Ler a idade do usuário
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Informe a idade: "));
			
			// Exibir a idade
			System.out.println("A idade do usuário é " + idade);
		} catch(NumberFormatException e) {
			System.out.println("Número inválido");
			System.out.println(e.getMessage());
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Index inválido");
		} finally {
			System.out.println("Bloco que sempre executa");
		}
		
		System.out.println("Finalizando o programa!");
	}//MAIN
}//CLASS