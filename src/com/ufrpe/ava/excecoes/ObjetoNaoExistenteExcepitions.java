package com.ufrpe.ava.excecoes;

@SuppressWarnings("serial")
public class ObjetoNaoExistenteExcepitions extends Exception{

	
	public ObjetoNaoExistenteExcepitions(String nome){
		
		super(nome + "Não existente no sistema");
		
	}
	

	
}
