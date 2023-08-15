package br.com.fiap.vetores.view;

public class Exemplo01 {
	public static void main(String[] args) {
		//Definir um vetor de nomes de carro
		String[] nomes = new String[5];
		//Definir o nome de 5 carros
		nomes[0] = "gol";
		nomes[1] = "uno";
		nomes[2] = "santana";
		nomes[3] = "onix";
		nomes[4] = "corsa";
		//Exibir o nome dos carros
		for(int i = 0; i < nomes.length; i++) {
			System.out.println(nomes[i]);
		}
		//ForEach (for ("Tipo de dado" variavel : churros)
		for(String item : nomes) {
			System.out.println(item);
		}
		//Criar um vetor de notas de cp (10, 8, 7)
		float[] notas = new float[] {10, 8, 7};
		float somatoria = 0;
		float media;
		for(int i = 0; i<notas.length; i++) {
			somatoria += notas[i];
		}
		media = somatoria/notas.length;
		System.out.println(media);
		//ForEach da nota
		for(float item : notas) {
			System.out.println(item);
		}
	}//MAIN
}//CLASS