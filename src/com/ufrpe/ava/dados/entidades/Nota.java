package com.ufrpe.ava.dados.entidades;

public class Nota extends Entidade{
	private int[] notas = new int[4];//1ª,2ª,3ª, final
	private String situacao;
	private Aluno aluno;
	private OfertaDisciplina oferta;
	
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public OfertaDisciplina getOferta() {
		return oferta;
	}

	public void setOferta(OfertaDisciplina oferta) {
		this.oferta = oferta;
	}

	public int[] getNotas() {
		return notas;
	}

	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
	public void setarNota(int indice, int nota){
		this.notas[indice] = nota;
	}
}
