package com.ufrpe.ava.dados.entidades;

import java.util.HashMap;
import java.util.Map;

public class Curso extends Entidade{
	private String nome;
	private int quantAlunos;
	private Map<Integer, Disciplina> gradeDisciplina = new HashMap<Integer, Disciplina>(); //Integer é o período e a Disciplina
	private Departamento departamento;
	private int codCurso;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantAlunos() {
		return quantAlunos;
	}
	public void setQuantAlunos(int quantAlunos) {
		this.quantAlunos = quantAlunos;
	}
	public Map<Integer, Disciplina> getGradeDisciplina() {
		return gradeDisciplina;
	}
	public void setGradeDisciplina(Map<Integer, Disciplina> gradeDisciplina) {
		this.gradeDisciplina = gradeDisciplina;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codigo) {
		this.codCurso = codigo;
	}
}
