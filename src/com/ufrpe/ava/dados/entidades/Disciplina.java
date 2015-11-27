package com.ufrpe.ava.dados.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Disciplina extends Entidade{
	private int codDisciplina;
	private String nome;
	private int cargaHoraria;
	private int creditos;
	private int tipo; //não sei o que é
	//String = dia, Integer = horário. Uma disciplina pode ter mais de um horário
	private Map<String, Integer> horario = new HashMap<String, Integer>();
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
	public Map<String, Integer> getHorario() {
		return horario;
	}
	public void setHorario(Map<String, Integer> horario) {
		this.horario = horario;
	}
	public ArrayList<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(ArrayList<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
