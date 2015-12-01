package com.ufrpe.ava.negocio;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.classes_basicas.Aluno;
import com.ufrpe.ava.negocio.classes_basicas.Professor;
import com.ufrpe.ava.negocio.classes_basicas.Usuario;

/**
 * Created by paulomenezes on 20/11/15.
 */
public interface IAvaFachada {
	
	public Aluno cadastrarAluno(String nome, String cpf,String email, String senha,int codCurso,String tipo,char grad);
	public Professor cadastarProfessor(String nome, String cpf,String email, String senha,int idDepartamento,char grad);
	public Usuario buscarLogin(String cpf, String senha)throws ObjetoNaoExistenteExcepitions;
	public ArrayList<Usuario> selecionarTudo();

}
