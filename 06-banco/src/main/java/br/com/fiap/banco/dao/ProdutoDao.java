package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.model.Produto;

//Realiza as ações de CRUD (Create, Read, Update, Delete) no banco de dados
public class ProdutoDao {
	
	public void cadastrar(Produto produto) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Obter a conexão com o banco de dados
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
		System.out.println("Conectado!");
		
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO T_PRODUTO(CD_PRODUTO,NM_PRODUTO,"
				+ "NR_ESTOQUE,VL_VENDA,VL_COMPRA) VALUES (?,?,?,?,?)");
		
		stmt.setInt(1, produto.getCodigo());
		stmt.setString(2, produto.getNome());
		stmt.setInt(3, produto.getNumeroEstoque());
		stmt.setDouble(4, produto.getValorVenda());
		stmt.setDouble(5, produto.getValorCompra());
		
		stmt.executeUpdate();
		System.out.println("Produto cadastrado com sucesso");
		
		conn.close();
	}
	
	public Produto pesquisarPorId(int id) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Obter a conexão com o banco de dados
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
		System.out.println("Conectado!");
		
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PRODUTO WHERE CD_PRODUTO = ?");
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			return new Produto(rs.getInt("CD_PRODUTO"), rs.getInt("NR_ESTOQUE"), rs.getString("NM_PRODUTO"), rs.getDouble("VL_VENDA"), rs.getDouble("VL_COMPRA"));
		} else {
			return null;
			
		}
		
	}
	
	public List<Produto> listar() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//Obter a conexão com o banco de dados
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
		System.out.println("Conectado!");
		
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM T_PRODUTO");
		List<Produto> produtos = null;
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			produtos.add(new Produto(rs.getInt("CD_PRODUTO"), rs.getInt("NR_ESTOQUE"), rs.getString("NM_PRODUTO"), rs.getDouble("VL_VENDA"), rs.getDouble("VL_COMPRA")));
		}
		return produtos;
	}
}//CLASS