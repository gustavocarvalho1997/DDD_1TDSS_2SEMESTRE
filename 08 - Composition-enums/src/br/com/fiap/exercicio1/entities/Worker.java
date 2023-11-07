package br.com.fiap.exercicio1.entities;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.exercicio1.entities.enums.WorkerLevel;

public class Worker {
	// Atributos
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	// Associações
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	// Construtores
	public Worker() {
		super();
	}
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		super();
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}
	// Getters
	public String getName() {
		return name;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public Double getBaseSalary() {
		return baseSalary;
	}
	public Department getDepartment() {
		return department;
	}
	public List<HourContract> getContracts() {
		return contracts;
	}
	// Setters
	public void setName(String name) {
		this.name = name;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	// Métodos
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	public double income(int year, int month) {
		double sum = baseSalary;
		for(HourContract c : contracts) {
			int c_year = c.getDate().getYear();
			int c_month = c.getDate().getMonthValue();
			if(c_year == year && c_month == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}//CLASS