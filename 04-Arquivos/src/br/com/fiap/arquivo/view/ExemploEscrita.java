package br.com.fiap.arquivo.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ExemploEscrita {
	public static void main(String[] args) {
		
		try {
			//Criar o outputstream
			FileWriter outputstream = new FileWriter("churros.txt", true);
			//Objeto para escrever em um arquivo
			PrintWriter arquivo = new PrintWriter(outputstream);
			//Escrever no arquivo
			while(true) {
				String escrita = JOptionPane.showInputDialog("Informe o que deseja armazenar no arquivo: ");
				arquivo.println(escrita);
				
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite 1 para armazenar outra informação e 2 para encerrar: "));
				if(opcao == 2) {
					break;
				}
			}
			
			
			//Fechar os recursos abertos
			arquivo.close();
			outputstream.close();
			
			System.out.println("Escreveu no arquivo!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// MAIN
}// CLASS