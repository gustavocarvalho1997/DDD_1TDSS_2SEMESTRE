package br.com.fiap.banco.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ExemploConexao {
	public static void main(String[] args) {
		//Conectar no banco de dados
		
		//Registrar o driver do banco de dados utilizado
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Obter a conexão com o banco de dados
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
			System.out.println("Conectado!");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//MAIN
}//CLASS