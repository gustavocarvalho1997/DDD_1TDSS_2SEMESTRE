package br.com.fiap.banco.view;

import br.com.fiap.banco.dao.ProdutoDao;
import br.com.fiap.banco.model.Produto;

public class Terminal {
	public static void main(String[] args) {
		//Instanciar um produto (a ideia é que o usuario informe os dados)
		Produto produto = new Produto(1, 10, "Chocolate", 2, 1);
		//Instanciar o objeto que é capaz de realizar as ações no banco de dados
		ProdutoDao dao = new ProdutoDao();
		//Gravar no banco
		dao.cadastrar(produto);
		
	}//MAIN
}//CLASS