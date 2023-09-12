package br.com.fiap.banco.view;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercicio1 {
	public static void main(String[] args) {
		//Conectar no banco de dados
		
		//Registrar o driver do banco de dados utilizado
		try {
			FileReader inputStream = new FileReader("alunos.csv");
			BufferedReader arquivoEntrada = new BufferedReader(inputStream);	
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
			System.out.println("Conectado!");
							

			Statement stm = conn.createStatement();
			arquivoEntrada.readLine();//ler a primeira linha
			String linha;
			while((linha = arquivoEntrada.readLine()) != null) {
				String[] arrDados = linha.split(";");
				int nrRm = Integer.parseInt(arrDados[0]);
				String nmAluno = arrDados[1];
				int stAtivo = 0;
				if(arrDados[2].equalsIgnoreCase("true")) {
					stAtivo = 1;
				} else if(arrDados[2].equalsIgnoreCase("false")) {
					stAtivo = 0;
				}
				double vlNota1 = Double.parseDouble(arrDados[3]);
				double vlNota2 = Double.parseDouble(arrDados[4]);
				stm.execute("INSERT INTO TB_ALUNO (nr_rm, nm_aluno, st_ativo, vl_nota1, vl_nota2)"
						+ "VALUES(" + nrRm + ", '" + nmAluno + "', " + stAtivo + ", " + vlNota1 + ", " + vlNota2 + ")");
			}
			
			arquivoEntrada.close();
						
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//MAIN
}//CLASS