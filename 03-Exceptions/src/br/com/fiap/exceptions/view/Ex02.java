package br.com.fiap.exceptions.view;
import br.com.fiap.exceptions.model.*;
public class Ex02 {
	public static void main(String[] args) {
		Produto produto = new Produto("Arroz", 10.50);
		
		//produto.calcularImposto(-1);
		produto.calcularValorTotal(0);
		
		
	}// MAIN
}// CLASS