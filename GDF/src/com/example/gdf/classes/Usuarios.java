package com.example.gdf.classes;

public class Usuarios {
	
	private int ID;
	private String Login;
	private String Senha;

	public Usuarios (int ID,String Login, String Senha){
		this.ID = ID;
		this.Login = Login;
		this.Senha = Senha;
	}
	
	public Usuarios (String Login, String Senha){
		this.Login = Login;
		this.Senha = Senha;
	}
	
	public Usuarios (){
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getLogin() {
		return Login;
	}
	
	public void setLogin(String login) {
		Login = login;
	}
	
	public String getSenha() {
		return Senha;
	}
	
	public void setSenha(String senha) {
		Senha = senha;
	}
}
