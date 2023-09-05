package br.com.fiap.arquivo.view;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExemploLeitura {
	public static void main(String[] args) {
		//Ler o arquivo e exibir o conteúdo
		try {
			FileReader inputStream = new FileReader("churros.txt");
			BufferedReader arquivoEntrada = new BufferedReader(inputStream);
			
			String linha;
			StringBuffer texto = new StringBuffer();
			while((linha = arquivoEntrada.readLine()) != null) {
				texto.append(linha).append("\n");
			}
			
			arquivoEntrada.close();
			inputStream.close();
			System.out.println(texto);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Fazer com que o usuário possa escrever o que será gravado no arquivo
	}// MAIN
}// CLASS