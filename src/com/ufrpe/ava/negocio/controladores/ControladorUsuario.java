package com.ufrpe.ava.negocio.controladores;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.entidades.Aluno;
import com.ufrpe.ava.negocio.entidades.Professor;
import com.ufrpe.ava.negocio.entidades.Usuario;

public class ControladorUsuario {
	
	
	public Usuario buscarLogin(String cpf, String senha)throws ObjetoNaoExistenteExcepitions{
		
		Usuario usuario = buscarUsuario(cpf,senha);
		 
		if(usuario == null){
			
			throw new ObjetoNaoExistenteExcepitions("Usu�rio",cpf);
		}
		
		return usuario;
	}
	
	private Usuario buscarUsuario(String cpf, String senha){
		
		return null;
	}
	
	public ArrayList<Usuario> selecionarTudo(){
		
		return null;
	}
	
	public void cadastrarAluno(String nome, String cpf,String email, String senha,int codCurso,String tipo,int grad) 
			throws Exception,ObjetoNaoExistenteExcepitions,ObjetoJaExistenteExcepitions{
		
			Aluno aluno = new Aluno(nome,cpf,email,senha,grad,tipo, codCurso);
			cadastrarUsuario(aluno);
		
	}
	
	public void cadastrarProfessor(String nome, String cpf,String email, String senha,int idDpto,int grad) 
			throws Exception,ObjetoNaoExistenteExcepitions,ObjetoJaExistenteExcepitions{
		
		Professor professor = new Professor(nome, cpf,email,senha,grad,idDpto);
		cadastrarUsuario(professor);
	}
	
	private void cadastrarUsuario(Usuario usuario) throws Exception,ObjetoNaoExistenteExcepitions,ObjetoJaExistenteExcepitions{
		//Chamado pelo AspectoCadastrar
	}
	
	
	@SuppressWarnings("unused")
	private boolean buscaPorCodigo(int codigo, String nomeTabela){
		
		return true;
	}

}
