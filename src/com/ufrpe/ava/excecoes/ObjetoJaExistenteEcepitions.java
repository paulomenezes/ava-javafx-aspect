package com.ufrpe.ava.excecoes;

@SuppressWarnings("serial")
public class ObjetoJaExistenteEcepitions extends Exception {

	public ObjetoJaExistenteEcepitions(String nome){
		
		super(nome+ "Ja existe no sistema");
	}
}
