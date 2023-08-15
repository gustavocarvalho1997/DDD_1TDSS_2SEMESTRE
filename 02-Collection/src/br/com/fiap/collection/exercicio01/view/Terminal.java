package br.com.fiap.collection.exercicio01.view;
import br.com.fiap.collection.exercicio01.classes.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Terminal {
	public static void main(String[] args) {
		ArrayList<Produto> listaProduto= new ArrayList<>();
		int quantidadeProdutos = Integer.parseInt(JOptionPane.showInputDialog("Quantos produtos serão cadastrados?"));
		
		for(int i = 0; i < quantidadeProdutos ; i++) {
			int qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade desse produto:"));
			float preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o valor do produto: "));
			float descontoEmReais = Float.parseFloat(JOptionPane.showInputDialog("Informe o desconto em reais desse produto: "));
			
			listaProduto.add(new Produto(qtd, preco, descontoEmReais));
		}// FOR
		
		float valorTotal = 0;
		for(int i = 0; i < listaProduto.size(); i++) {
			valorTotal += listaProduto.get(i).retornarValorTotal();
		}
		
		System.out.println(valorTotal);
		
	}// MAIN
}// CLASS