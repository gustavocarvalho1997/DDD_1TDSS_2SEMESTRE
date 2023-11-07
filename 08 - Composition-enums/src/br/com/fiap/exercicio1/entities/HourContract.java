package br.com.fiap.exercicio1.entities;

import java.time.LocalDate;

public class HourContract {
	// Atributos
	private LocalDate date;
	private Double valuePerHour;
	private Integer hours;
	
	// Construtores
	public HourContract() {
		super();
	}
	public HourContract(LocalDate date, Double valuePerHour, Integer hours) {
		super();
		this.date = date;
		this.valuePerHour = valuePerHour;
		this.hours = hours;
	}
	// Getters
	public LocalDate getDate() {
		return date;
	}
	public Double getValuePerHour() {
		return valuePerHour;
	}
	public Integer getHours() {
		return hours;
	}
	// Setters
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public void setValuePerHour(Double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}
	// Métodos
	public double totalValue() {
		return valuePerHour * hours;
	}
}//CLASS