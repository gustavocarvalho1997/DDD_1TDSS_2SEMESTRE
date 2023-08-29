package br.com.fiap.collection.exercicio07.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		ArrayList<Double> numeros = new ArrayList<>();
		
		
		for(int i = 0; i < 16; i++) {
			double numeroInformado = Double.parseDouble(JOptionPane.showInputDialog("Informe o número desejado: "));
			numeros.add(numeroInformado);
		}
		List<Double> l1 = numeros.subList(0, 8);
		List<Double> l2 = numeros.subList(8, 16);
		
		ArrayList<Double> numerosReposicionados = new ArrayList<>();
		numerosReposicionados.addAll(l2);
		numerosReposicionados.addAll(l1);
		
		for(int i = 0; i < numerosReposicionados.size(); i++) {
			System.out.println(numerosReposicionados.get(i));
		}
		
		
	}// MAIN
}// CLASS