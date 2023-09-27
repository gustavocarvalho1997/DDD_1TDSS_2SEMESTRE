package br.com.fiap.banco.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Cria conexões com o banco de dados
public class ConnectionFactory {
	
	//static -> método pertence a classe e não ao objeto
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
				"RM552466", "160297");
		return conn;
	}
}//CLASS