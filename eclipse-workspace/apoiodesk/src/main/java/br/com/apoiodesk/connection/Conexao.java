package br.com.apoiodesk.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection conn = null;
	private static String url = "jdbc:postgresql://localhost:5432/sisdoc";
	private static String user = "postgres";
	private static String password = "123456";
	
	public Conexao() {
		conectar();
	}
	
	static {
		conectar();
	}
	
	public static Connection getConnection(){
		return conn;
	}

	
	//Metodo conexão com o banco
	public static void conectar() {
		try {
			if (conn == null || conn.isClosed()) {		
				
				Class.forName("org.postgresql.Driver");	
				
				conn = DriverManager.getConnection(url,user,password);
				conn.setAutoCommit(false);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar o banco", e);
		}
		
	}
	

}
