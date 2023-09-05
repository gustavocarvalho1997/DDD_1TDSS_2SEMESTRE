package br.com.fiap.arquivo.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercicio2Terminal {
	public static void main(String[] args) {
		try {
			FileReader inputStream = new FileReader("numeros.txt");
			BufferedReader arquivoEntrada = new BufferedReader(inputStream);
			
			FileWriter outputStream = new FileWriter("numerosSomados.txt", true);
			PrintWriter arquivoSaida = new PrintWriter(outputStream);
			
			String linha;
			
			while((linha = arquivoEntrada.readLine()) != null) {
				int virgulaIndex = linha.indexOf(",");
				int num1 = Integer.parseInt(linha.substring(0, virgulaIndex));
				int num2 = Integer.parseInt(linha.substring(virgulaIndex+1));
				int soma = num1 + num2;
				arquivoSaida.println(num1 + "," + num2 + "," + soma);
			}
			
			
			inputStream.close();
			arquivoEntrada.close();
			arquivoSaida.close();
			outputStream.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}
