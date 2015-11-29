package com.ufrpe.ava.negocio.classes_basicas;

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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((tipoAluno == null) ? 0 : tipoAluno.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (tipoAluno == null) {
			if (other.tipoAluno != null)
				return false;
		} else if (!tipoAluno.equals(other.tipoAluno))
			return false;
		return true;
	}	
	
	
}
