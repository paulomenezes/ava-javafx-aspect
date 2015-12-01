package com.ufrpe.ava.negocio;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.classes_basicas.Usuario;

/**
 * Created by paulomenezes on 20/11/15.
 */
public interface IAvaFachada {
	
	public void cadastrarAluno(String nome, String cpf,String email, String senha,int codCurso,String tipo,int grad) 
			throws Exception,ObjetoNaoExistenteExcepitions,ObjetoJaExistenteExcepitions;
	public void cadastarProfessor(String nome, String cpf,String email, String senha,int idDepartamento,int grad) 
			throws Exception,ObjetoNaoExistenteExcepitions,ObjetoJaExistenteExcepitions;
	public Usuario buscarLogin(String cpf, String senha)throws ObjetoNaoExistenteExcepitions;
	public ArrayList<Usuario> selecionarTudo();

}
