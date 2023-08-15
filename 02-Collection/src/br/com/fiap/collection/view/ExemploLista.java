package br.com.fiap.collection.view;

import java.util.ArrayList;

public class ExemploLista {
	public static void main(String[] args) {
		// Criar uma lista de plastas
		ArrayList<String> lista = new ArrayList<>();
		
		// Adicionar algumas plantas
		lista.add("Rosa");
		lista.add("Orelha de Gato");
		lista.add("Costela de Adão");
		lista.add("Girassol");
		
		// Adicionar um valor repetido
		lista.add("Girassol");
		
		// Adiciona o elemento em uma determinada posição
		lista.add(0, "Rabo de macaco");
		
		// Substituir o elemento da posição 4
		lista.set(4, "Rabo de macaco");
		
		// Remover a Rosa
		lista.remove("Rosa");
		
		// Recuperar elemento da posição 2
		System.out.println(lista.get(2));
		
		//Remover todos os elementos da lista
		// lista.clear();
		
		// Verificar se existe a planta "Orelha de Gato" na lista
		System.out.println(lista.contains("Orelha de Gato"));;
		
		//Exibir a quantidade de plantas na lista
		System.out.println(lista.size());
		
		//Exibir todas as plantas
		for(String item : lista) {
			System.out.println(item);
		}
		
		
		
	}//MAIN
}//CLASS