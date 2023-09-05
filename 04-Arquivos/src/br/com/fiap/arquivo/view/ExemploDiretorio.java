package br.com.fiap.arquivo.view;

import java.io.File;
import java.io.IOException;

public class ExemploDiretorio {
	public static void main(String[] args) {
		//Criar um objeto que representa um diretorio
		File pasta = new File("empresa");
		//Validar se o diretório existe
		if(pasta.exists()) {
			//Exibir caminho do diretório
			System.out.println(pasta.getAbsolutePath());
			//Renomear o diretório para "departamento"
			//pasta.renameTo(new File("departamento"));
			//Criar um arquivo orcamento.csv dentro do diretório departamento
			File arquivo = new File(pasta, "orcamento.csv");
			if(!arquivo.exists()) {
				try {
					arquivo.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			pasta.mkdir();
			System.out.println("Diretório criado");
		}
	}//Main
}//Class