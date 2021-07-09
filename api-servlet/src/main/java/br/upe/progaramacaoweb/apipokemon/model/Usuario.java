package br.upe.progaramacaoweb.apipokemon.model;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String email;
	private static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

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

	public static void addUser(Usuario usuario) {
		usuarios.add(usuario);
	}

	public static ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public static void setUsuarios(ArrayList<Usuario> usuarios) {
		Usuario.usuarios = usuarios;
	}

}
