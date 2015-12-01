package com.ufrpe.ava.excecoes;

import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class ObjetoNaoExistenteExcepitions extends Exception{

	private String nome;
	private String especificacao;
	private String horaExcecao;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm"); 
	
	public ObjetoNaoExistenteExcepitions(String nome,String especificacao){
		
		super(nome+" "+especificacao+"N�o Escontrado /n Por favor Digite outro "+nome);
		this.setNome(nome);
		this.setEspecificacao(especificacao);
		this.setHoraExcecao(sdf.format(new Date()));
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecificacao() {
		return especificacao;
	}

	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public String getHoraExcecao() {
		return horaExcecao;
	}

	public void setHoraExcecao(String string) {
		this.horaExcecao = string;
	}

	
	

	
}
