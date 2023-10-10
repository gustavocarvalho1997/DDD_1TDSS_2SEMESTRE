package br.com.fiap.banco.view;

import java.sql.Connection;

import br.com.fiap.banco.dao.ProdutoDao;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Produto;

//View
public class Terminal {

	public static void main(String[] args) {
		Connection conn = null;
		//Gravar no banco
		try {
			//Instanciar um produto (a ideia é que o usuário informe os dados)
			Produto produto = new Produto(50, "Churros de Doce de Leite", 15, 15, 10);
			conn = ConnectionFactory.getConnection();
			//Instanciar o objeto que é capaz de realizar as ações no banco de dados
			ProdutoDao dao = new ProdutoDao(conn);
			//dao.cadastrar(produto);
			dao.deletar(produto.getCodigo());
			System.out.println("sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
}