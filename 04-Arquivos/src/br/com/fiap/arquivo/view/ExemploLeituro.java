package br.com.fiap.arquivo.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploLeituro {
	public static void main(String[] args) {
		//Ler o arquivo e exibir o conteúdo
		try {
			FileReader inputStream = new FileReader("churros.txt");
			BufferedReader arquivoEntrada = new BufferedReader(inputStream);
			
			String linha;
			
			while((linha = arquivoEntrada.readLine()) != null) {
				System.out.println(linha);
			}
			
			arquivoEntrada.close();
			inputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Fazer com que o usuário possa escrever o que será gravado no arquivo
	}// MAIN
}// CLASS