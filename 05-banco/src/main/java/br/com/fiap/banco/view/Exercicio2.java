package br.com.fiap.banco.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercicio2 {
	public static void main(String[] args) {
		try {
			FileWriter outputStream = new FileWriter("exercicio2.csv");
			PrintWriter arquivoSaida = new PrintWriter(outputStream);
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
			System.out.println("Conectado!");
			Statement stm = conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT * FROM TB_ALUNO");
			
			arquivoSaida.println("RM;Nome;Ativo;Nota1;Nota2");
			while(result.next()) {
				int rm = result.getInt("nr_rm");
				String nome = result.getString("nm_aluno");
				int stAtivo = result.getInt("st_ativo");
				boolean status = false;
				if(stAtivo == 1) {
					status = true;
				} else if (stAtivo == 0) {
					status = false;
				}
				int vlNota1 = result.getInt("vl_nota1");
				int vlNota2 = result.getInt("vl_nota2");
				
				arquivoSaida.println(rm + ";" + nome + ";" + status + ";" + vlNota1 + ";" + vlNota2);
			}
			System.out.println("Informações salvas com sucesso!");
			arquivoSaida.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}//MAIN
}//CLASS