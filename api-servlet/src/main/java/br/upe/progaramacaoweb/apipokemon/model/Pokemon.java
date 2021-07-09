package br.upe.progaramacaoweb.apipokemon.model;

import java.util.List;

public class Pokemon {

	private Integer id;
	private String nome;
	private Integer base;
	private Integer peso;
	private List<Tipos> tipos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public List<Tipos> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipos> tipos) {
		this.tipos = tipos;
	}

}
