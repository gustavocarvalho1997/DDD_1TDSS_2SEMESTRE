package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.banco.model.Categoria;

public class CategoriaDao {
	//Atributos
	private Connection conn;
	//Statements
	private static final String CADASTRAR = "INSERT INTO TB_CATEGORIA ()";
	//Construtor
	public CategoriaDao(Connection conn) {
		this.conn = conn;
	}//CategoriaDao
	
	public void cadastrar(Categoria categoria) throws SQLException {
		
	}
	
}//Class