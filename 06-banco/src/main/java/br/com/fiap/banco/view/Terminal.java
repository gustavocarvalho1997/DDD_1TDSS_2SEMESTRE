package br.com.fiap.banco.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.ProdutoDao;
import br.com.fiap.banco.exception.IdInexistenteException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Produto;

//View
public class Terminal {

	public static void main(String[] args) {
		//Gravar no banco
		try {
			//Instanciar um produto (a ideia é que o usuário informe os dados)
			Produto produto = new Produto(50, "Churros de Doce de Leite", 15, 15, 10);
			Connection conn = ConnectionFactory.getConnection();
			//Instanciar o objeto que é capaz de realizar as ações no banco de dados
			ProdutoDao dao = new ProdutoDao(conn);
			//dao.cadastrar(produto);
			dao.deletar(produto.getCodigo());
			System.out.println("sucesso");
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