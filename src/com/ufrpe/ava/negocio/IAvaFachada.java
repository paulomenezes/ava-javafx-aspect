package com.ufrpe.ava.negocio;

import java.util.ArrayList;

import com.ufrpe.ava.dados.entidades.Usuario;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;

/**
 * Created by paulomenezes on 20/11/15.
 */
public interface IAvaFachada {
	
	public void cadastrarAluno();
	public void cadastarProfessor();
	public Usuario login(String cpf, String senha)throws ObjetoNaoExistenteExcepitions;
	public ArrayList<Usuario> selecionarTudo();
	public Object cadastrarUsuario(String text, String text2, String text3, String text4);

}
