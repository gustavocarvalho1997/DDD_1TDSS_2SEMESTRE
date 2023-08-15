package br.com.fiap.vetores.exercicio01.view;
import javax.swing.JOptionPane;

import br.com.fiap.vetores.exercicio01.classes.*;
public class Terminal {
	public static void main(String[] args) {
		//Atributo
		float valorTotalEmReais = 0;
		//Quantidade de produtos que serão registrados
		Produto produtos[] = new Produto[Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produtos a serem registrados:"))];
		//Registrando produtos
		for(int i = 0 ; i < produtos.length; i++) {
			float preco = Float.parseFloat(JOptionPane.showInputDialog("Informe o preço do produto:"));
			float DescontoEmReais = Float.parseFloat(JOptionPane.showInputDialog("Informe o desconto em reais:"));
			int qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade deste produto:"));

			produtos[i] = new Produto(qtd, preco, DescontoEmReais);
			
			valorTotalEmReais += produtos[i].retornarValorAPagar();
		}
		//Mostra o valor total dos produtos somados
		JOptionPane.showConfirmDialog(null, "O valor total foi de : R$" + valorTotalEmReais);
		
		
		
	}//MAIN
}//CLASS