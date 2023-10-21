package br.com.fiap.banco.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.dao.CategoriaDao;
import br.com.fiap.banco.dao.ProdutoDao;
import br.com.fiap.banco.exception.BadInfoException;
import br.com.fiap.banco.exception.IdNotFoundException;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.model.Categoria;
import br.com.fiap.banco.model.Produto;

public class ProdutoService {
	private ProdutoDao produtoDao;
	private CategoriaDao categoriaDao;
	public ProdutoService() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionFactory.getConnection();
		produtoDao = new ProdutoDao(conn);
		categoriaDao = new CategoriaDao(conn);
	}
	
	//CADASTRAR
	public void cadastrar (Produto produto) throws BadInfoException, ClassNotFoundException, SQLException {
		//Implementar algumas regras:
		//Nome é obrigatório e não pode ter mais do que 50 caracteres
		if(produto.getNome() == null || produto.getNome().length() > 50) {
			throw new BadInfoException("Nome inválido, não pode ser nulo e no máximo 50 caracteres!");
		}
		//Estoque, valor de compra e venda tem que ser maiores do que 0
		if(produto.getEstoque() > 0 && produto.getValorCompra() > 0 && produto.getValorVenda() > 0) {
			throw new BadInfoException("Estoque, valor de compra e valor de venda devem ser maiores que 0");
		}
		//Valor de venda deve ser maior do que valor de compra
		if(produto.getValorVenda() > produto.getValorCompra()) {
			throw new BadInfoException("Valor de venda deve ser maior do que o valor de compra!");
		}
		//Lembrar de mudar resource no post pra bad request
		
		produtoDao.cadastrar(produto);
	}
	
	//LISTAR
	public List<Produto> listar() throws ClassNotFoundException, SQLException {
		List<Produto> lista = produtoDao.listar();
		return lista;
	}
	
	
	//PESQUISAR POR CÓDIGO
	public Produto pesquisar(int codigo) throws ClassNotFoundException, SQLException, IdNotFoundException {
		Produto p = produtoDao.pesquisar(codigo);
		//Recuperar a categoria do produto, se existir
		if(p.getCategoria() != null) {
			Categoria c = categoriaDao.pesquisarPorId(p.getCategoria().getId());
			p.setCategoria(c);
		}
		return p;
	}
	
	//ATUALIZAR
	public void atualizar(Produto produto) throws ClassNotFoundException, SQLException, IdNotFoundException {
		produtoDao.atualizar(produto);
	}
	
	//DELETAR
	public void remover(int id) throws ClassNotFoundException, SQLException, IdNotFoundException {
		produtoDao.remover(id);
	}
}//CLASS