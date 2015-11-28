package com.ufrpe.ava.dados.entidades;

import java.util.ArrayList;

public class Disciplina extends Entidade{
	private int codDisciplina;
	private String nome;
	private int cargaHoraria;
	private int creditos;
	private String tipo; //não sei o que é
	//String = dia, Integer = horário. Uma disciplina pode ter mais de um horário
	private ArrayList<Disciplina> preRequisitos = new ArrayList<Disciplina>();
	
	public int getCodDisciplina() {
		return codDisciplina;
	}
	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public ArrayList<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(ArrayList<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
