package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.banco.exception.IdInexistenteException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Produto;

//Realiza as ações de CRUD (Create, Read, Update, Delete) no banco de dados
public class ProdutoDao {

	public void cadastrar(Produto produto) throws ClassNotFoundException, SQLException  {
		//Abrir a conexão com o banco
		Connection conn = ConnectionFactory.getConnection();
		
		
		//Criar o objeto com o comando SQL configurável
		PreparedStatement stm = conn.prepareStatement("INSERT INTO"
				+ " T_PRODUTO (cd_produto, nm_produto, nr_estoque,"
				+ " vl_venda, vl_compra) values (?, ?, ?, ?, ?)");
		
		//Setar os valores no comando SQL
		stm.setInt(1, produto.getCodigo());
		stm.setString(2, produto.getNome());
		stm.setInt(3, produto.getEstoque());
		stm.setDouble(4, produto.getValorVenda());
		stm.setDouble(5, produto.getValorCompra());
		
		//Executar o comando SQL
		stm.executeUpdate();
	}
	
	public List<Produto> listar() throws ClassNotFoundException, SQLException{
		//Criar a conex ão com o banco de dados
		Connection conn = ConnectionFactory.getConnection();
		//Criar o comando SQL
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM T_PRODUTO");
		//Executar o comando SQL
		ResultSet rs = stm.executeQuery();
		//Criar a lista de produtos
		ArrayList<Produto> lista = new ArrayList<Produto>();
		//Percorrer todos os registros encontrados	
		while(rs.next()) {
			//Recuperar os valores das colunas
			int id = rs.getInt("cd_produto");
			String nome = rs.getString("nm_produto");
			int estoque = rs.getInt("nr_estoque");
			double valorVenda = rs.getDouble("vl_venda");
			double valorCompra = rs.getDouble("vl_compra");
			//Instanciar um produto com esses valores
			Produto pd = new Produto(id, nome, estoque, valorVenda, valorCompra);
			//Adicionar na lista
			lista.add(pd);
		}
		//Retornar a lista de produto
		return lista;
	}
	
	//Deixar para depois
	public Produto pesquisar(int id) throws ClassNotFoundException, SQLException, IdInexistenteException {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stm = conn.prepareStatement("SELECT * FROM T_PRODUTO WHERE cd_produto = ?");
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if(rs.next()) {
			//Recuperar os valores das colunas
			int cd = rs.getInt("cd_produto");
			String nome = rs.getString("nm_produto");
			int estoque = rs.getInt("nr_estoque");
			double valorVenda = rs.getDouble("vl_venda");
			double valorCompra = rs.getDouble("vl_compra");
			//Instanciar um produto com esses valores
			Produto pd = new Produto(cd, nome, estoque, valorVenda, valorCompra);
			return pd;
		} else {
			throw new IdInexistenteException("O Id informado não existe!");
		}
	}
	//FAZER O UPDATE E O DELETE
	
}