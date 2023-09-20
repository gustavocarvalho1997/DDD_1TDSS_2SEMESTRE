package br.com.fiap.banco.view;

import java.sql.SQLException;

import br.com.fiap.banco.dao.ProdutoDao;
import br.com.fiap.banco.model.Produto;

public class Terminal {
	public static void main(String[] args) {
		//Instanciar um produto (a ideia é que o usuario informe os dados)
		Produto produto = new Produto(4, 10, "Chocolate", 2, 1);
		//Instanciar o objeto que é capaz de realizar as ações no banco de dados
		ProdutoDao dao = new ProdutoDao();
		//Gravar no banco
		try {
			//dao.cadastrar(produto);
			System.out.println(dao.listar());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//MAIN
}//CLASS