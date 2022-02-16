package br.com.alura.model;

public class Categoria {

	private int id;
	private String nome;

	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "ID: " + this.id + " Nome: " + this.nome;
	}

}
