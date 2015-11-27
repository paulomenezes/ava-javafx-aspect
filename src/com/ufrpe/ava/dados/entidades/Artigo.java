package com.ufrpe.ava.dados.entidades;

public class Artigo extends Entidade{
	private String nome; //tem de adicionar essa coluna na tabela para fazer sentido
	private String tema;
	private String objetivo;
	private String area;
	private ProjetoPesquisa projeto; //na tabela mostra idProjeto como chave estrangeira
	
	// tem adicionar um tipo string para o texto do arquivo em si ou um tipo file
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public String getObjetivo() {
		return objetivo;
	}
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public ProjetoPesquisa getProjeto() {
		return projeto;
	}
	public void setProjeto(ProjetoPesquisa projeto) {
		this.projeto = projeto;
	}
}
