package com.example.gdf.classes;

public class Filmes {
	private int ID;
	private String nome;
	private String diretor;
	private String produtor;
	private String historia;
	private String genero;

	public Filmes(){
	}
	
	public Filmes(String nome,String diretor, String produtor,String historia,String genero){
		setNome(nome);
		setDiretor(diretor);
		setProdutor(produtor);
		setHistoria(historia);
		setGenero(genero);
	}
	
	public Filmes(int ID, String nome,String diretor, String produtor,String historia,String genero){
		setID(ID);
		setNome(nome);
		setDiretor(diretor);
		setProdutor(produtor);
		setHistoria(historia);
		setGenero(genero);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDiretor() {
		return diretor;
	}
	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	public String getProdutor() {
		return produtor;
	}
	public void setProdutor(String produtor) {
		this.produtor = produtor;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
