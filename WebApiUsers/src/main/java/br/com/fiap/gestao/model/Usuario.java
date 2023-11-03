package br.com.fiap.gestao.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Usuario {
	//ATRIBUTOS
	private int codigo;
	private String nome;
	private String email;
	private String cpf;
	@JsonFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
	private LocalDateTime dataCadastro;
	@JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataNascimento;
	
	//CONSTRUTOR
	public Usuario(int codigo, String nome, String email, String cpf, LocalDateTime dataCadastro,
			LocalDate dataNascimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataCadastro = dataCadastro;
		this.dataNascimento = dataNascimento;
	}
	public Usuario() {
		super();
	}
	
	//GETTERS
	public int getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getCpf() {
		return cpf;
	}
	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	//SETTERS
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
}//CLASS