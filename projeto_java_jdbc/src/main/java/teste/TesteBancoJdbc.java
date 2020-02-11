package teste;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import conexaojdbc.Conexao;
import dao.UserEstudoJavaDAO;
import model.BeanUserFone;
import model.Telefone;
import model.UserEstudoJava;

public class TesteBancoJdbc {
	@Test
	public void initBanco() {
		Conexao.getConnection();
	}

	@Test
	public void testBuscarBanco() {
		UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
		List<UserEstudoJava> lista = new ArrayList<UserEstudoJava>();
		lista = userDAO.buscarTodos();
		for (UserEstudoJava listar : lista) {
			System.out.println(listar.toString());
		}
	}

	@Test
	public void testBuscarInner() {
		UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
		UserEstudoJava user = new UserEstudoJava();
		user.setId(12L);
		
		List<BeanUserFone> lista = new ArrayList<BeanUserFone>();
		
		lista = userDAO.buscarTodosInner(user);
		for (BeanUserFone listar : lista) {
			System.out.println(listar.toString());
		}
	}
	@Test
	public void testInserirUser() {
		UserEstudoJava user = new UserEstudoJava();
		UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
		user.setEmail("joaomaria@yahoo.com.br");
		user.setNome("Joao Maria");
		userDAO.inserirUser(user);
		testBuscarBanco();
	}

	@Test
	public void testAlterarUser() {
		UserEstudoJava user = new UserEstudoJava();
		UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
		user.setId(1L);
		user.setNome("Maria Silva");
		user.setEmail("Mariazinha@gmail");
		userDAO.alterarUser(user);
		testBuscarBanco();
	}

	@Test
	public void testDeleteUser() {
		UserEstudoJava user = new UserEstudoJava();
		UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
		user.setId(3L);
		userDAO.excluirUser(user);
		testBuscarBanco();
	}
	@Test
	public void testApagarTodos() {
		UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
		userDAO.apagarTodos();
		testBuscarBanco();
	}
	@Test
	public void testSalvarTel() {
		Telefone telefone = new Telefone();
		UserEstudoJavaDAO telefoneDAO = new UserEstudoJavaDAO();
		telefone.setNumero("71993410330");
		telefone.setTipo("Celular");
		telefone.setUsuario(12L);
		telefoneDAO.salvarTelefone(telefone);
	
	}
}