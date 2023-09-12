package br.com.fiap.banco.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploPesquisa {
	public static void main(String[] args) {
		//Conectar no banco de dados
		
		//Registrar o driver do banco de dados utilizado
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Obter a conexão com o banco de dados
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
			System.out.println("Conectado!");
			
			//Pesquisar produtos
			Statement stm = conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT * FROM T_PRODUTO");
			
			//Percorrer todos os registros encontrador
			while(result.next()) {
				//Recuperar os valores dos campos de cada registro
				int codigo = result.getInt("cd_produto");
				String nomeProduto = result.getString("nm_produto");
				
				//Imprimir os valores
				System.out.println(codigo + " " + nomeProduto);
			}
				
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}//CLASS