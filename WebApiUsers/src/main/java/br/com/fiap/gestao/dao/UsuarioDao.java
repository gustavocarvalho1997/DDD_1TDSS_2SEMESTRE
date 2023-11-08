package br.com.fiap.gestao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.gestao.excecption.IdNotFoundException;
import br.com.fiap.gestao.interfaces.IUsuarioDao;
import br.com.fiap.gestao.model.Usuario;

public class UsuarioDao implements IUsuarioDao{
	// Atributos
	private Connection conn;
	// Statements
	private static final String CADASTRAR = "INSERT INTO TB_USUARIO (CD_USUARIO, NM_USUARIO, DT_CADASTRO, DT_NASCIMENTO, DS_EMAIL, NR_CPF) VALUES (SQ_TB_USUARIO.NEXTVAL, ?, ?, ?, ?, ?)";
	private static final String LISTAR = "SELECT * FROM TB_USUARIO ORDER BY CD_USUARIO";
	private static final String PESQ_CD = "SELECT * FROM TB_USUARIO WHERE CD_USUARIO = ?";
	private static final String DELETAR = "DELETE FROM TB_USUARIO WHERE CD_USUARIO = ?";
	private static final String ATUALIZAR = "UPDATE TB_USUARIO SET NM_USUARIO = ?, DT_NASCIMENTO = ?, DS_EMAIL = ?, NR_CPF = ? WHERE CD_USUARIO = ?";
	// Construtor
	public UsuarioDao(Connection conn) {
		this.conn = conn;
	}
	
	// Parse INICIO
	private Usuario parse(ResultSet rs) throws SQLException {
		int codigo = rs.getInt("CD_USUARIO");
		String nome = rs.getString("NM_USUARIO");
		Timestamp dt1 = rs.getTimestamp("DT_CADASTRO");
		LocalDateTime dataCadastro = dt1.toLocalDateTime();
		Timestamp dt2 = rs.getTimestamp("DT_NASCIMENTO");
		LocalDate dataNascimento = dt2.toLocalDateTime().toLocalDate();
		//tbm poderia LocalDate dt = rs.getObject("dt_cadastro", LocalDateTime.class)
		String email = rs.getString("DS_EMAIL");
		String cpf = rs.getString("NR_CPF");
		
		Usuario user = new Usuario(codigo, nome, email, cpf, dataCadastro, dataNascimento);
		return user;
	}// Parse FIM
	
	// Cadastrar INICIO
	public void cadastrar(Usuario usuario) throws SQLException {
		PreparedStatement stm = conn.prepareStatement(CADASTRAR, new String[] {"CD_USUARIO"});
		stm.setString(1, usuario.getNome());
		usuario.setDataCadastro(LocalDateTime.now());
		stm.setObject(2, usuario.getDataCadastro());
		stm.setObject(3, usuario.getDataNascimento());
		stm.setString(4, usuario.getEmail());
		stm.setString(5, usuario.getCpf());
		
		stm.executeUpdate();
		// Recuperar o valor gerado pela sequence, o código do usuário
		ResultSet result = stm.getGeneratedKeys();
		result.next();
		int codigo = result.getInt(1);
		usuario.setCodigo(codigo);
	}// Cadastro FIM

	// Listar INICIO
	public List<Usuario> listar() throws SQLException {
		PreparedStatement stm = conn.prepareStatement(LISTAR);
		ResultSet rs = stm.executeQuery();
		List<Usuario> lista = new ArrayList<>();
		while(rs.next()) {
			Usuario user = parse(rs);
			lista.add(user);
		}
		return lista;
	}// Listar FIM

	// PesquisarPorCodigo INICIO
	public Usuario pesquisarPorCodigo(int codigo) throws SQLException, IdNotFoundException {
		PreparedStatement stm = conn.prepareStatement(PESQ_CD);
		stm.setInt(1, codigo);
		ResultSet rs = stm.executeQuery();
		if(!rs.next()) {
			throw new IdNotFoundException("Código informado não foi localizado!");
		} else {
			Usuario user = parse(rs);
			return user;
		}
	}// PesquisarPorCodigo FIM

	// Atualizar INICIO
	public void atualizar(Usuario usuario) throws SQLException, IdNotFoundException {
		pesquisarPorCodigo(usuario.getCodigo());
		PreparedStatement stm = conn.prepareStatement(ATUALIZAR);
		stm.setString(1, usuario.getNome());
		stm.setObject(2, usuario.getDataNascimento());
		stm.setString(3, usuario.getEmail());
		stm.setString(4, usuario.getCpf());
		stm.setInt(5, usuario.getCodigo());
		
		stm.executeUpdate();
	}// Atualizar FIM

	// Deletar INICIO
	public void deletar(int codigo) throws SQLException, IdNotFoundException {
		pesquisarPorCodigo(codigo);
		PreparedStatement stm = conn.prepareStatement(DELETAR);
		stm.setInt(1, codigo);
		
		stm.executeUpdate();
	}// Deletar FIM
}//CLASS