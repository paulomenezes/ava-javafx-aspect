package com.ufrpe.ava.dados.entidades;

public class OfertaDisciplina extends Entidade{
	private int quantAlunos;
	private Disciplina disciplina;
	private int ano;
	private int semestre;
	//private Map<Aluno, Nota> alunosMatriculados_Situacao = new HashMap<Aluno, Nota>();
	private Curso curso; //uma oferta disciplina pode ser criada em diferentes cursos com o mesmo parametro
	//facilita na pesquisa por histórico
	
	public int getQuantAlunos() {
		return quantAlunos;
	}
	public void setQuantAlunos(int quantAlunos) {
		this.quantAlunos = quantAlunos;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	//provavelmente não é necessário, a confirmar
	/*
	public Map<Aluno, Nota> getAlunosMatriculados_Situacao() {
		return alunosMatriculados_Situacao;
	}
	public void setAlunosMatriculados_Situacao(Map<Aluno, Nota> alunosMatriculados_Situacao) {
		this.alunosMatriculados_Situacao = alunosMatriculados_Situacao;
	}
	*/
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
}
