package br.com.fiap.arquivo.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Exercicio1Terminal {
	public static void main(String[] args) {
		try {
			FileReader inputStream = new FileReader("churros.txt");
			BufferedReader arquivoEntrada = new BufferedReader(inputStream);
			
			String linha;
			StringBuffer texto = new StringBuffer();
			
			while((linha = arquivoEntrada.readLine()) != null) {
				texto.append(linha).append("\n");
			}
			
			String newTexto = texto.toString().replaceAll("[^a-zA-Z\s\n]", "");
			
			System.out.println(newTexto);
			
			inputStream.close();
			arquivoEntrada.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}
