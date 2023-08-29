package br.com.fiap.exercicio.view;

import javax.swing.JOptionPane;

import br.com.fiap.exercicio.model.ContaCorrente;

public class TesteContaCorrente {
	public static void main(String[] args) {
		// Instanciar uma ContaCorrente com valor e limite
		double saldo = Double.parseDouble(JOptionPane.showInputDialog("Informe o saldo: "));
		double limite = Double.parseDouble(JOptionPane.showInputDialog("Informe o limite: "));
		ContaCorrente conta = new ContaCorrente(saldo, limite);
		
		// Setar limite
		limite = Double.parseDouble(JOptionPane.showInputDialog("Informe o novo limite: "));
		try {
			conta.setLimite(limite);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Depositar na conta
		double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser depositado: "));
		try {
			conta.depositar(valorDeposito);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		//Sacar da conta
		double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor a ser sacado: "));
		try {
			conta.sacar(valorSaque);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}// MAIN
}// CLASS