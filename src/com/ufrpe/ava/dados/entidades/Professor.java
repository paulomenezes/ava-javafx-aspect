package com.ufrpe.ava.dados.entidades;

import java.util.ArrayList;

public class Professor extends Usuario{
	private ArrayList<ProjetoPesquisa> projetosPesquisa;

	public Professor(){
		projetosPesquisa = new ArrayList<ProjetoPesquisa>();
	}
	public ArrayList<ProjetoPesquisa> getProjetosPesquisa() {
		return projetosPesquisa;
	}

	public void setProjetosPesquisa(ArrayList<ProjetoPesquisa> projetosPesquisa) {
		this.projetosPesquisa = projetosPesquisa;
	}
	
}
