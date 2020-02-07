package br.com.monthalcantara.conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {

			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/estudojava", "postgres", "admin");

			System.out.println("Conectado com sucesso");

		} catch (SQLException e) {
			System.out.println("Erro ao conectar: " + e.getMessage());
		}
		return con;
	}
}
