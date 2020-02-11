package model;

public class BeanUserFone{
private String numero;
private String nome;
private String email;
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	this.numero = numero;
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
@Override
public String toString() {
	return "BeanUserFone [numero=" + numero + ", nome=" + nome + ", email=" + email + "]";
}

}
