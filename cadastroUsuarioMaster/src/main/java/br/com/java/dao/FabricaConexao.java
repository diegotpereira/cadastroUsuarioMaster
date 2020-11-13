package br.com.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
	
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/devmedia";
	String usuario = "root";
	String senha = "root";
	
	private static FabricaConexao conexao;
	
	private FabricaConexao() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	public Connection getConexao() throws SQLException {
		
		Connection con = null;
		con = DriverManager.getConnection(url, usuario, senha);
		return con;
		
	}
	public static FabricaConexao getInstance() {
		if (conexao == null) {
			conexao = new FabricaConexao();
		}
		return conexao;
		
	}

}
