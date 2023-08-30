package br.com.fiap.arquivo.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ExemploEscrita {
	public static void main(String[] args) {
		
		try {
			//Criar o outputstream
			FileWriter outputstream = new FileWriter("churros.txt", true);
			//Objeto para escrever em um arquivo
			PrintWriter arquivo = new PrintWriter(outputstream);
			//Escrever no arquivo
			arquivo.println("Ronald pagou R$14,00 em um churros!");
			arquivo.println("Quando poderia ter pago R$7,50!");
			
			//Fechar os recursos abertos
			arquivo.close();
			outputstream.close();
			
			System.out.println("Escreveu no arquivo!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// MAIN
}// CLASS