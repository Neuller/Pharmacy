package br.com.farmacia.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	private static final String USUARIO = "root";
	private static final String SENHA = "123456";
	private static final String URL = "jdbc:mysql://localhost:3306/Sistema";

	public static Connection conectar() throws SQLException {
		
		// Referência ao Driver MySQL para Versões Antigas do JAVA
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
		return conexao;
	}

	public static void main(String[] args) {

		try {
			Connection conexao = ConexaoFactory.conectar();
			System.out.println("Conectado com Suscesso!");
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Conexão Falhou!");
		}
	}

}
