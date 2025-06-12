package br.com.apoiodesk.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection conn = null;
	
	//Metodo conexão com o banco
	public static Connection getConnection() {
		try {
			if (conn == null || conn.isClosed()) {
				String url = "jdbc:postgresql://localhost:5432/sisdoc";
				String user = "postgres";
				String password = "123456";
				
				Class.forName("org.postgresql.Driver");
				
				conn = DriverManager.getConnection(url,user,password);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar o banco", e);
		}
		return conn;
	}
	

}
