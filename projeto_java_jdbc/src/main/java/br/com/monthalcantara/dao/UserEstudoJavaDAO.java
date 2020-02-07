package br.com.monthalcantara.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.monthalcantara.conexaojdbc.Conexao;
import br.com.monthalcantara.model.UserEstudoJava;

public class UserEstudoJavaDAO {
	Connection con = Conexao.getConnection();

	public void inserirUser(UserEstudoJava user) {

		String sql = "insert into userestudojava (id, nome, email) values (?,?,?)";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setLong(1, user.getId());
			preparador.setString(2, user.getNome());
			preparador.setString(3, user.getEmail());
			preparador.execute();
			preparador.close();
			System.out.println("Usuário cadastrado com Sucesso!!!");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public void excluirUser(UserEstudoJava user) {
		String sql = "delete from userestudojava where id = ?";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setLong(1, user.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Usuário excluído com Sucesso!!!");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	public void alterarUser(UserEstudoJava user) {

		String sql = "update userestudojava set nome = ?, email=? where id= ?";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, user.getNome());
			preparador.setString(2, user.getEmail());
			preparador.setLong(3, user.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Usuário Atualizado com Sucesso!!!");

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

	public List<UserEstudoJava> buscarTodos() {
		String sql = "select * from userestudojava";

		List<UserEstudoJava> lista = new ArrayList<UserEstudoJava>();
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				UserEstudoJava user = new UserEstudoJava();
				user.setId(resultado.getLong("id"));
				user.setNome(resultado.getString("nome"));
				user.setEmail(resultado.getString("email"));
				lista.add(user);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return lista;
	}

}
