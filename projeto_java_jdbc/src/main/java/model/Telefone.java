package model;

import conexaojdbc.Conexao;

public class Telefone {

	private Long id;
	private String numero;
	private String tipo;
	private Long usuariopessoa;
	
	public Telefone() {
		Conexao.getConnection();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getUsuario() {
		return usuariopessoa;
	}
	public void setUsuario(Long usuario) {
		this.usuariopessoa = usuario;
	}
	
	
	
}
