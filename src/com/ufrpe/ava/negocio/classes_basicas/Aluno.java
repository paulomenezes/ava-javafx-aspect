package com.ufrpe.ava.negocio.classes_basicas;

public class Aluno extends Usuario{
	private String tipoAluno; //mestrado, doutorado, graduando
	private int curso;
	
	
	public Aluno(){
		
	}
	
	public Aluno(String nome, String cpf,String email, String senha,char grad,String tipoAluno, int curso) {
		super(cpf,nome,email, null, senha, grad);
		this.tipoAluno = tipoAluno;
		this.curso = curso;
	}
	
	public String getTipoAluno(){
		return tipoAluno;
	}
	public void setTipoAluno(String tipoAluno) {
		this.tipoAluno = tipoAluno;
	}
	
	public int getCurso() {
		return curso;
	}
	public void setCurso(int codCurso) {
		this.curso = codCurso;
	}
	

	
	
}
