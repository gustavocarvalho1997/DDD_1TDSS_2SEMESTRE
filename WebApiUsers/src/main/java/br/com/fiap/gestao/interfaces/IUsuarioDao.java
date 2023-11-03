package br.com.fiap.gestao.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.gestao.excecption.IdNotFoundException;
import br.com.fiap.gestao.model.Usuario;

public interface IUsuarioDao {
	// Cadastrar
	void cadastrar(Usuario usuario) throws SQLException;
	// Listar
	List<Usuario> listar() throws SQLException;
	// PesquisarPorCodigo
	Usuario pesquisarPorCodigo(int codigo) throws SQLException, IdNotFoundException;
	// Atualizar
	void atualizar(Usuario usuario) throws SQLException, IdNotFoundException;
	// Deletar
	void deletar(int codigo) throws SQLException, IdNotFoundException;
}// INTERFACE