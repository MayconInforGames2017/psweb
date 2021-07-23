package br.com.pswmaycon.empregado.model;

public class Empregado {

	private int id;
	private String nome;
	private String sobreNome;

	public Empregado(int id, String nome, String sobreNome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobreNome = sobreNome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

}
