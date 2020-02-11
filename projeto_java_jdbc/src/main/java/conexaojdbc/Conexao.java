package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	private static Connection con = null;
	private static PreparedStatement preparador;
	private static ResultSet resultado;

	public static Connection getConnection() {
		if (con == null) {
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

		}
		return con;
	}

	public static void fecharConexao(Connection con) {
		if (con != null) {
			try {
				System.out.println("Conexão Fechada");
				con.close();

			} catch (SQLException e) {
				System.err.println("Erro: " + e);

			}
		}
	}

	public static void fecharConexao(Connection con, PreparedStatement preparador) {
		if (preparador != null) {
			try {
				preparador.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);

			} finally {
				fecharConexao(con);
			}
		}
	}

	public static void fecharConexao(Connection con, PreparedStatement preparador, ResultSet resultado) {
		if (resultado != null) {
			try {
				resultado.close();
			} catch (SQLException e) {
				System.err.println("Erro: " + e);

			} finally {
				fecharConexao(con, preparador);
			}
		}
	}
}
