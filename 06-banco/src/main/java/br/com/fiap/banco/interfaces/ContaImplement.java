package br.com.fiap.banco.interfaces;

import java.sql.SQLException;
import java.util.List;

import br.com.fiap.banco.exception.AccountNotFoundException;
import br.com.fiap.banco.exception.IdInexistenteException;
import br.com.fiap.banco.exception.InsufficientFundsException;
import br.com.fiap.banco.model.Conta;

public interface ContaImplement {

	//Cadastrar INICIO
	void cadastrar(Conta conta) throws SQLException;//Cadastrar FIM

	//Listar INICIO
	List<Conta> listar() throws SQLException;//Listar FIM

	//PesquisarPorId INICIO
	Conta pesquisarPorId(int id) throws SQLException, IdInexistenteException;//PesquisarPorId FIM

	//PesquisarPorNumero INICIO
	Conta pesquisarPorNumero(String numero) throws SQLException, AccountNotFoundException;//PesquisarPorNumero FIM

	//Deletar INICIO
	void deletar(int id) throws SQLException, IdInexistenteException;//Deletar FIM

	//Atualizar INICIO
	void atualizar(Conta conta) throws SQLException, IdInexistenteException;//Atualizar FIM

	//Transferência INICIO
	void transferir() throws SQLException, AccountNotFoundException, IdInexistenteException, InsufficientFundsException;//Transferência FIM

}