package com.ufrpe.ava.dados.entidades;

public class Aluno extends Usuario{
	private String tipoAluno; //mestrado, doutorado, graduando
	private Curso curso;
	
	public String getTipoAluno(){
		return tipoAluno;
	}
	public void setTipoAluno(String tipoAluno) {
		this.tipoAluno = tipoAluno;
	}
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}	
	
}
