package br.com.fiap.exercicio1.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JOptionPane;

import br.com.fiap.exercicio1.entities.Department;
import br.com.fiap.exercicio1.entities.HourContract;
import br.com.fiap.exercicio1.entities.Worker;
import br.com.fiap.exercicio1.entities.enums.WorkerLevel;

public class Terminal {
	public static void main(String[] args) {
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		String departmentName = JOptionPane.showInputDialog("Enter department's name: ");
		JOptionPane.showConfirmDialog(null, "Now, enter with worker data: ");
		String name = JOptionPane.showInputDialog("Name: ");
		String workerLevel = JOptionPane.showInputDialog("Level: ");
		double baseSalary = Double.parseDouble(JOptionPane.showInputDialog("Base salary: "));
		
		Worker worker = new Worker(name, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
	
		int n = Integer.parseInt(JOptionPane.showInputDialog("How many contracts to this worker? "));
		for(int i = 1; i<=n; i++) {
			JOptionPane.showConfirmDialog(null, "Enter contract " + i + " data:");
			LocalDate ld = LocalDate.parse(JOptionPane.showInputDialog("Date (DD/MM/YYYY)"), dtf1);
			double valuePerHour = Double.parseDouble(JOptionPane.showInputDialog("Value per hour: "));
			int hours = Integer.parseInt(JOptionPane.showInputDialog("Duration (hours): "));
			HourContract contract = new HourContract(ld, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		String[] monthAndYear = JOptionPane.showInputDialog("Enter month and year to calculate income(MM/YYYY): ").split("/");
		int month = Integer.parseInt(monthAndYear[0]);
		int year = Integer.parseInt(monthAndYear[1]);
		
		System.out.println("Name: " + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear[0] + "/" + monthAndYear[1] + ": " + String.format("%.2f", worker.income(year, month)));
	}//MAIN
}//CLASS