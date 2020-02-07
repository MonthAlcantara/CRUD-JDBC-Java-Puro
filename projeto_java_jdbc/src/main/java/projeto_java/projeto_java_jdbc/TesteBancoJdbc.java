package projeto_java.projeto_java_jdbc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import conexaojdbc.Conexao;
import junit.framework.TestCase;
import model.UserEstudoJava;
import model.UserEstudoJavaDAO;

public class TesteBancoJdbc{
@Test
public void initBanco() {
	Conexao.getConnection();
}
@Test
public void testBuscarBanco() {
	UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
	List<UserEstudoJava> lista = new ArrayList();
	lista = userDAO.buscarTodos();
	for(UserEstudoJava listar : lista) {
		System.out.println(listar.toString());
	}
}
@Test
public void testInserirUser() {
	UserEstudoJava user = new UserEstudoJava();
	UserEstudoJavaDAO userDAO = new UserEstudoJavaDAO();
	user.setEmail("joaosilva@yahoo.com.br");
	user.setId(1L);
	user.setNome("Joao da Silva");
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
	user.setId(1L);
	userDAO.excluirUser(user);
	testBuscarBanco();
}
}