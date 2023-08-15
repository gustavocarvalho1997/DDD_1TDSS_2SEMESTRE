package br.com.fiap.collection.view;

import java.util.HashSet;

public class ExemploConjunto {
	public static void main(String[] args) {
		// Criar um conjunto de Cores
		HashSet<String> conjunto = new HashSet<>();
		
		//Adicionar 4 cores no conjunto
		conjunto.add("Branco");
		conjunto.add("Preto");
		conjunto.add("Azul");
		conjunto.add("Amarelo");
		
		//Adicionar um valor repetifo
		conjunto.add("Branco");//ignorado
		
		//Exibir a quantidade de elementos no conjunto
		System.out.println(conjunto.size());
		
		//Exibir as cores do conjunto
		for(String item : conjunto) {
			System.out.println(item);
		}
		
	}//MAIN
}//CLASS