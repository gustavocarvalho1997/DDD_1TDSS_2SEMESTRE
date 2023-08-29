package br.com.fiap.exceptions.view;
import javax.swing.JOptionPane;

import br.com.fiap.exceptions.exception.ImpostoInvalidoException;
import br.com.fiap.exceptions.exception.QuantidadeInvalidaException;
import br.com.fiap.exceptions.model.*;
public class Ex02 {
    public static void main(String[] args) {
        Produto produto = new Produto("Arroz", 10.50);
        
        try {
            double imposto = Double.parseDouble(JOptionPane.showInputDialog("Digite o imposto: "));
            double valor = produto.calcularImposto(imposto);
            System.out.println(valor);
            int qtd = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de produto:"));
            double valorTotal = produto.calcularValorTotal(qtd);
            System.out.println(valorTotal);
        } catch(NumberFormatException e) {
            System.err.println("Imposto deve ser um número ");
        } catch(ImpostoInvalidoException e) {
            System.err.println(e.getMessage());
        } catch(QuantidadeInvalidaException e) {
            System.err.println(e.getMessage());
        }
        
        
        
    }// MAIN
}// CLASS