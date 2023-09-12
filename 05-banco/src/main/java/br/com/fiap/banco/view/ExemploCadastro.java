package br.com.fiap.banco.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExemploCadastro {
	public static void main(String[] args) {
		//Conectar no banco de dados
		
		//Registrar o driver do banco de dados utilizado
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Obter a conexão com o banco de dados
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM552466", "160297");
			System.out.println("Conectado!");
					
			//Cadastrar um produto no banco
			//Obter o objeto que executa comandos SQL
			Statement stm = conn.createStatement();
			//Executar um comando SQL no banco
			stm.execute("INSERT INTO T_PRODUTO (cd_produto, nm_produto, nr_estoque, vl_venda, vl_compra)" + "VALUES(3, 'Churros de chocolate', 10, 14.00, 6.50)");
				
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
					e.printStackTrace();
		}
	}//MAIN
}//CLASS