package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.Conexao;
import model.BeanUserFone;
import model.Telefone;
import model.UserEstudoJava;

public class UserEstudoJavaDAO {
	Connection con = Conexao.getConnection();

	public void inserirUser(UserEstudoJava user) {

		String sql = "insert into userestudojava ( nome, email) values (?,?)";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, user.getNome());
			preparador.setString(2, user.getEmail());
			preparador.execute();
			preparador.close();
			System.out.println("Usuário cadastrado com Sucesso!!!");

		} catch (SQLException e) {

			System.err.println("Erro: " + e);
		}

	}

	public void excluirUser(UserEstudoJava user) {
		String sql = "delete from userestudojava where id = ?";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setLong(1, user.getId());
			preparador.execute();
			if (preparador.execute() == false) {
				System.out.println("Usuario não encontrado");
			} else {
				System.out.println("Usuário excluído com Sucesso!!!");
			}
			preparador.close();

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
			if (!resultado.next()) {
				System.out.println("Não existem dados no banco para serem exibidos");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lista;
	}

	public void apagarTodos() {
		String sql = "delete from userestudojava";
		try {

			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.execute();
			if (preparador.execute() == false) {
				System.out.println("Tabela vazia");
			} else {
				System.out.println("Dados de tabela excluídos com Sucesso!!!");
			}
			preparador.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void salvarTelefone(Telefone telefone) {
		String sql = "insert into telefoneuser (numero, tipo, usuariopessoa) values (?,?,?)";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, telefone.getNumero());
			preparador.setString(2, telefone.getTipo());
			preparador.setLong(3, telefone.getUsuario());
			preparador.execute();
			System.out.println("Telefone salvo com Sucesso");
			Conexao.fecharConexao(con, preparador);
		} catch (SQLException e) {
			System.err.println("Erro: " + e);
		}

	}

	public List<BeanUserFone> buscarTodosInner(UserEstudoJava user) {
		String sql = "select * from telefoneuser as fone inner join userestudojava as userp on fone.usuariopessoa = userp.id where userp.id= "
				+ user.getId();
		List<BeanUserFone> listaBean = null;
		try {
			BeanUserFone bean = null;
			listaBean = new ArrayList<BeanUserFone>();
			PreparedStatement preparador = con.prepareStatement(sql);
			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()) {
				bean = new BeanUserFone();
				bean.setNumero(resultado.getString("numero"));
				bean.setEmail(resultado.getString("email"));
				bean.setNome(resultado.getString("nome"));
				listaBean.add(bean);

			}

			Conexao.fecharConexao(con, preparador, resultado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaBean;

	}
}
