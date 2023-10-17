package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.model.Categoria;

public class CategoriaDao {
	//Atributos
	private Connection conn;
	//Statements
	private static final String CADASTRAR = "INSERT INTO TB_CATEGORIA (ID, NM_CATEGORIA, ST_PERECIVEL) VALUES (?, ?, ?)";
	private static final String LISTAR = "SELECT * FROM TB_CATEGORIA ORDER BY ID";
	private static final String PESQ_ID = "SELECT * FROM TB_CATEGORIA WHERE ID = ?";
	private static final String DELETAR = "DELETE FROM TB_CATEGORIA WHERE ID = ?";
	private static final String ATUALIZAR = "UPDATE TB_CATEGORIA SET NM_CATEGORIA = ?, ST_PERECIVEL = ? WHERE ID = ?";
	//Construtor
	public CategoriaDao(Connection conn) {
		this.conn = conn;
	}//CategoriaDao
	
	//Parse INICIO
	private Categoria parse(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID");
		String nome = rs.getString("NM_CATEGORIA");
		boolean perecivel = (rs.getInt("ST_PERECIVEL") == 1) ? true : false;
		Categoria categoria = new Categoria(id, nome, perecivel);
		return categoria;
	}
	
	//Cadastrar INICIO
	public void cadastrar(Categoria categoria) throws SQLException {
		PreparedStatement stm = conn.prepareStatement(CADASTRAR);
		stm.setInt(1, categoria.getId());
		stm.setString(2, categoria.getCategoria());
		stm.setBoolean(3, categoria.isPerecivel());
		
		stm.executeUpdate();
	}//Cadastrar FIM
	
	//Listar INICIO
	public List<Categoria> listar() throws SQLException {
		PreparedStatement stm = conn.prepareStatement(LISTAR);
		ResultSet rs = stm.executeQuery();
		List<Categoria> lista = new ArrayList<>();
		while(rs.next()) {
			Categoria categoria = parse(rs);
			lista.add(categoria);
		}
		return lista;
	}//Listar FIM
	
	//PesquisarPorId INICIO
	public Categoria pesquisarPorId(int id) throws SQLException, IdNotFoundException {
		PreparedStatement stm  = conn.prepareStatement(PESQ_ID);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if(!rs.next()) {
			throw new IdNotFoundException("Id não localizado");
		} else {
			Categoria categoria = parse(rs);
			return categoria;
		}
	}//PesquisarPorId FIM
	
	//Deletar INICIO
	public void deletar(int id) throws SQLException, IdNotFoundException {
		pesquisarPorId(id);
		PreparedStatement stm = conn.prepareStatement(DELETAR);
		stm.setInt(1, id);
		
		stm.executeUpdate();
	}//Deletar FIM
	
	//Atualizar INICIO
	public void atualizar(Categoria categoria) throws SQLException, IdNotFoundException {
		pesquisarPorId(categoria.getId());
		PreparedStatement stm = conn.prepareStatement(ATUALIZAR);
		stm.setString(1, categoria.getCategoria());
		int perecivel = (categoria.isPerecivel()) ? 1 : 0;
		stm.setInt(2, perecivel);
		stm.setInt(3, categoria.getId());
		
		stm.executeUpdate();
	}//Atualizar FIM
	
	
}//Class