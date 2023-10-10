package br.com.fiap.banco.view;

import java.sql.Connection;

import br.com.fiap.banco.dao.ContaDao;
import br.com.fiap.banco.factory.ConnectionFactory;
import br.com.fiap.banco.interfaces.ContaImplement;

public class TerminalConta {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			//Conta conta = new Conta("15976", "Ronald Trucker", "25164178595", 6000, true);
			//Conta conta = new Conta(1 ,"12358", "Gustavo Carvalho", "25164865325", 8800, true);
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			ContaImplement dao = new ContaDao(conn);
			
			dao.transferir();
			System.out.println("sucesso");
			
			
			conn.commit();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			try {
				conn.rollback();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.err.println(e1.getMessage());
			}
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//MAIN
}//CLASS