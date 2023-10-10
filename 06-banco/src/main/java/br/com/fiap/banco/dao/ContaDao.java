package br.com.fiap.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.banco.exception.AccountNotFoundException;
import br.com.fiap.banco.exception.IdInexistenteException;
import br.com.fiap.banco.exception.InsufficientFundsException;
import br.com.fiap.banco.interfaces.ContaImplement;
import br.com.fiap.banco.model.Conta;

public class ContaDao implements ContaImplement {
	//Atributos
	private Connection conn;
	
	//Statements
	private static final String CADASTRAR = "INSERT INTO TB_CONTA (ID_CONTA, NUMERO_CONTA, NOME_TITULAR, CPF, ATIVO, SALDO) VALUES (SQ_CONTA.NEXTVAL, ?, ?, ?, ?, ?)";
	private static final String LISTAR = "SELECT * FROM TB_CONTA ORDER BY ID_CONTA";
	private static final String PESQ_ID = "SELECT * FROM TB_CONTA WHERE ID_CONTA = ?";
	private static final String PESQ_NUM = "SELECT * FROM TB_CONTA WHERE NUMERO_CONTA = ?";
	private static final String DELETAR = "DELETE FROM TB_CONTA WHERE ID_CONTA = ?";
	private static final String ATUALIZAR = "UPDATE TB_CONTA SET NUMERO_CONTA = ?, NOME_TITULAR = ?, CPF = ?, ATIVO = ?, SALDO = ? WHERE ID_CONTA = ?";
	//Construtores
	public ContaDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	//Parse INICIO
	private Conta parse(ResultSet rs) throws SQLException {
		int id = rs.getInt("ID_CONTA");
		String numero = rs.getString("NUMERO_CONTA");
		String nomeTitular = rs.getString("NOME_TITULAR");
		String cpf = rs.getString("CPF");
		boolean ativo = (rs.getInt("ATIVO") == 0) ? false : true;
		double saldo = rs.getDouble("SALDO");
		Conta conta = new Conta(id, numero, nomeTitular, cpf, saldo, ativo);
		
		return conta;
	}//parse FIM
	
	//Cadastrar INICIO
	public void cadastrar (Conta conta) throws SQLException{
		PreparedStatement stm = conn.prepareStatement(CADASTRAR);
		stm.setString(1, conta.getNumero());
		stm.setString(2, conta.getNomeTitular());
		stm.setString(3, conta.getCpf());
		int ativo = (conta.isAtivo()) ? 1 : 0; 
		stm.setInt(4, ativo);
		stm.setDouble(5, conta.getSaldo());
		
		stm.executeUpdate();
	}//Cadastrar FIM
	
	//Listar INICIO
	public List<Conta> listar() throws SQLException {
		PreparedStatement stm = conn.prepareStatement(LISTAR);
		ResultSet rs = stm.executeQuery();
		List<Conta> lista = new ArrayList<Conta>();
		while(rs.next()) {
			Conta conta = parse(rs);
			lista.add(conta);
		}
		return lista;
	}//Listar FIM
	
	//PesquisarPorId INICIO
	public Conta pesquisarPorId(int id) throws SQLException, IdInexistenteException {
		PreparedStatement stm = conn.prepareStatement(PESQ_ID);
		stm.setInt(1, id);
		ResultSet rs = stm.executeQuery();
		if(!rs.next()) {
			throw new IdInexistenteException("Id não localizado");
		} else {
			Conta conta = parse(rs);
			return conta;
		}
	}//PesquisarPorId FIM
	
	//PesquisarPorNumero INICIO
	public Conta pesquisarPorNumero(String numero) throws SQLException, AccountNotFoundException {
		PreparedStatement stm = conn.prepareStatement(PESQ_NUM);
		stm.setString(1, numero);
		ResultSet rs = stm.executeQuery();
		if(!rs.next()) {
			throw new AccountNotFoundException("Numero da conta não localizado");
		} else {
			Conta conta = parse(rs);
			return conta;
		}
	}//PesquisarPorNumero FIM
	
	//Deletar INICIO
	public void deletar(int id) throws SQLException, IdInexistenteException {
		pesquisarPorId(id);
		PreparedStatement stm = conn.prepareStatement(DELETAR);
		stm.setInt(1, id);
		
		stm.executeUpdate();
	}//Deletar FIM
	
	//Atualizar INICIO
	public void atualizar(Conta conta) throws SQLException, IdInexistenteException {
		pesquisarPorId(conta.getId());
		PreparedStatement stm = conn.prepareStatement(ATUALIZAR);
		stm.setString(1, conta.getNumero());
		stm.setString(2, conta.getNomeTitular());
		stm.setString(3, conta.getCpf());
		int ativo = (conta.isAtivo()) ? 1 : 0; 
		stm.setInt(4, ativo);
		stm.setDouble(5, conta.getSaldo());
		stm.setInt(6, conta.getId());
		
		stm.executeUpdate();
	}//Atualizar FIM
	
	//Transferência INICIO
	public void transferir() throws SQLException, AccountNotFoundException, IdInexistenteException, InsufficientFundsException {
		String contaOrigemNumero = JOptionPane.showInputDialog("Informe a conta de origem: ");
		Conta contaOrigem = pesquisarPorNumero(contaOrigemNumero);
		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja transferir: "));
		if(valor > contaOrigem.getSaldo()) {
			 throw new InsufficientFundsException(String.format("Seu saldo atual é de R$ %.2f , não será possivel realizar a transferência", contaOrigem.getSaldo()));
		}
		String contaDestinoNumero = JOptionPane.showInputDialog("Informe a conta de destino: ");
		Conta contaDestino = pesquisarPorNumero(contaDestinoNumero);
		contaOrigem.sacar(valor);
		contaDestino.depositar(valor);
		atualizar(contaOrigem);
		atualizar(contaDestino);
		
	}//Transferência FIM
	
	
	
}//CLASS