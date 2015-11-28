package com.ufrpe.ava.dados.entidades;

import java.util.ArrayList;

public class ProjetoPesquisa {
	private String nome;
	private String modalidade;
	private String organizacao; //cnpq, facepe etc
	private ArrayList<Aluno> alunos;
	private int codProjeto; 
	private ArrayList<Professor> professores;
	
	public ProjetoPesquisa(){
		this.alunos = new ArrayList<Aluno>();	
		this.professores = new ArrayList<Professor>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public String getOrganizacao() {
		return organizacao;
	}

	public void setOrganizacao(String organizacao) {
		this.organizacao = organizacao;
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

	public ArrayList<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}
}
