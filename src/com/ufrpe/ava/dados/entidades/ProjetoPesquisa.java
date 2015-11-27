package com.ufrpe.ava.dados.entidades;

import java.util.ArrayList;

public class ProjetoPesquisa {
	private String nome;
	private int modalidade; //tipo lá na tabela
	private ArrayList<Aluno> alunos;
	private int codProjeto; 
	
	public ProjetoPesquisa(){
		this.alunos = new ArrayList<Aluno>();		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getModalidade() {
		return modalidade;
	}
	public void setModalidade(int modalidade) {
		this.modalidade = modalidade;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public int getCodProjeto() {
		return codProjeto;
	}
	public void setCodProjeto(int codProjeto) {
		this.codProjeto = codProjeto;
	}

	
}
