package br.com.fiap.banco.view;

import java.sql.SQLException;

import br.com.fiap.banco.dao.ProdutoDao;
import br.com.fiap.banco.exception.IdInexistenteException;
import br.com.fiap.banco.model.Produto;

//View
public class Terminal {

	public static void main(String[] args) {
		
		//Instanciar um produto (a ideia é que o usuário informe os dados)
		//Produto produto = new Produto(6, "Caminhao", 1, 200000, 300000);
		
		//Instanciar o objeto que é capaz de realizar as ações no banco de dados
		ProdutoDao dao = new ProdutoDao();
		
		

		//Gravar no banco
		try {
			//dao.cadastrar(produto);
			System.out.println("Gravado!");
			System.out.println(dao.pesquisar(1).getNome());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}