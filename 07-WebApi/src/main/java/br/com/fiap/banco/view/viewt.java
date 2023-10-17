package br.com.fiap.banco.view;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.banco.dao.CategoriaDao;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Categoria;

public class viewt {
	public static void main(String[] args) {
		Connection conn;
		try {
			conn = ConnectionFactory.getConnection();
			CategoriaDao dao = new CategoriaDao(conn);
			Categoria cat = new Categoria(1, "Pescados", true);
			dao.cadastrar(cat);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
