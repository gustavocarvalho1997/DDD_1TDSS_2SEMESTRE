package br.com.fiap.gestao.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.fiap.gestao.dao.UsuarioDao;
import br.com.fiap.gestao.excecption.BadInfoException;
import br.com.fiap.gestao.excecption.IdNotFoundException;
import br.com.fiap.gestao.factory.ConnectionFactory;
import br.com.fiap.gestao.model.Usuario;
import br.com.fiap.gestao.util.UsuarioUtils;

public class UsuarioService {
	// Atributos
	private UsuarioDao usuarioDao;
	
	// Construtor
	public UsuarioService() throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionFactory.getConnection();
		usuarioDao = new UsuarioDao(conn);
	}
	
	// Cadastrar INICIO
	public void cadastrar(Usuario usuario) throws SQLException, BadInfoException {
		List<Usuario> lista = usuarioDao.listar();
		UsuarioUtils.checkStrings(usuario);
		UsuarioUtils.checkUniques(usuario, lista);
		usuarioDao.cadastrar(usuario);
	}// Cadastrar FIM
	
	// Listar INICIO
	public List<Usuario> listar() throws SQLException {
		return usuarioDao.listar();
	}// Listar FIM
	
	// PesquisarPorCodigo INICIO
	public Usuario pesquisarPorCodigo(int codigo) throws SQLException, IdNotFoundException {
		return usuarioDao.pesquisarPorCodigo(codigo);
	}// PesquisarPorCodigo FIM
	
	// Atualizar INICIO
	public void atualizar(Usuario usuario) throws SQLException, IdNotFoundException, BadInfoException {
		List<Usuario> lista = usuarioDao.listar();
		Usuario model = usuarioDao.pesquisarPorCodigo(usuario.getCodigo());
		UsuarioUtils.mergeUser(model, usuario);
		UsuarioUtils.checkStrings(usuario);
		UsuarioUtils.checkUniques(usuario, lista);
		usuarioDao.atualizar(usuario);
	}
	
	// Deletar INICIO
	public void deletar(int codigo) throws SQLException, IdNotFoundException {
		usuarioDao.deletar(codigo);
	}// Deletar FIM
}//CLASS