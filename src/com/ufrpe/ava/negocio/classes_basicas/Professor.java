package com.ufrpe.ava.negocio.classes_basicas;

public class Professor extends Usuario{
		
	private int idDpto;
	
	public Professor(){
		
	}
	
	public Professor(String nome, String cpf,String email, String senha,int grad,int idDpto) {
		super(cpf,nome,email, null, senha, grad);
		this.idDpto = idDpto;
	}


	public int getIdDpto() {
		return idDpto;
	}


	public void setIdDpto(int idDpto) {
		this.idDpto = idDpto;
	}
	
	
}
