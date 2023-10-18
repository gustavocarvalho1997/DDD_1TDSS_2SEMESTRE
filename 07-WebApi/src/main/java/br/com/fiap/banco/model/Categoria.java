package br.com.fiap.banco.model;

public class Categoria {
	//Atributos
	private int id;
	private String categoria;
	private boolean perecivel;
	//Construtores
	public Categoria(int id, String categoria, boolean perecivel) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.perecivel = perecivel;
	}//Categoria
	public Categoria(int id) {
		super();
		this.id = id;
	}
	public Categoria(String categoria, boolean perecivel) {
		super();
		this.categoria = categoria;
		this.perecivel = perecivel;
	}//Categoria
	public Categoria() {
		super();
	}
	
	//Getters
	public int getId() {
		return id;
	}
	public String getCategoria() {
		return categoria;
	}
	public boolean isPerecivel() {
		return perecivel;
	}
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public void setPerecivel(boolean perecivel) {
		this.perecivel = perecivel;
	}
	//toString
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", categoria=" + categoria + ", perecivel=" + perecivel + "]";
	}
	
	
	
}//CLASS