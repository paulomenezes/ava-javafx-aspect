package com.ufrpe.ava.dados.entidades;

public class SolicitacaoProjeto extends Entidade{
	private int codSolicitacao;
	private Aluno aluno;
	private ProjetoPesquisa projeto;
	private boolean estado;
	public int getCodSolicitacao() {
		return codSolicitacao;
	}
	public void setCodSolicitacao(int codSolicitacao) {
		this.codSolicitacao = codSolicitacao;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public ProjetoPesquisa getProjeto() {
		return projeto;
	}
	public void setProjeto(ProjetoPesquisa projeto) {
		this.projeto = projeto;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}
