package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.fiap.banco.dao.CategoriaDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Categoria;
import br.com.fiap.banco.model.Produto;

public class CategoriaService {
	private CategoriaDao categoriaDao;
	public CategoriaService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		categoriaDao = new CategoriaDao(conn);
	}
	
	//CADASTRAR
	public void cadastrar (Categoria categoria) throws BadInfoException, ClassNotFoundException, SQLException {
		if(categoria.getCategoria() == null) {
			throw new BadInfoException("O nome da categoria não pode ser nulo!");
		}
		categoriaDao.cadastrar(categoria);
	}
}//CLASS