package model;

public class UserEstudoJava {
private String nome;
private String email;
private Long id;



@Override
public String toString() {
	return "UserEstudoJava [Nome = " + nome + " | E-mail = " + email + " | Id = " + id + "]";
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getId() {
	return id;
}
public void setId(Long i) {
	this.id = i;
}

}
