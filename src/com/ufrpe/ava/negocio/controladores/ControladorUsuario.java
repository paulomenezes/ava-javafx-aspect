package com.ufrpe.ava.negocio.controladores;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.classes_basicas.Aluno;
import com.ufrpe.ava.negocio.classes_basicas.Professor;
import com.ufrpe.ava.negocio.classes_basicas.Usuario;

public class ControladorUsuario {
	
	
	public Usuario buscarLogin(String cpf, String senha)throws ObjetoNaoExistenteExcepitions{
		
		Usuario usuario = buscarUsuario(cpf,senha);
		 
		if(usuario == null){
			
			throw new ObjetoNaoExistenteExcepitions("Usuário",cpf);
		}
		
		return usuario;
	}
	
	private Usuario buscarUsuario(String cpf, String senha){
		
		return null;
	}
	
	public ArrayList<Usuario> selecionarTudo(){
		
		return null;
	}
	
	public void cadastrarAluno(String nome, String cpf,String email, String senha,int codCurso,String tipo,char grad){
		
			Aluno aluno = new Aluno(nome,cpf,email,senha,grad,tipo, codCurso);
			cadastrarUsuario(aluno);
		
	}
	
	public void cadastrarProfessor(String nome, String cpf,String email, String senha,int idDpto,char grad){
		
		Professor professor = new Professor(nome, cpf,email,senha,grad,idDpto);
		cadastrarUsuario(professor);
	}
	
	private void cadastrarUsuario(Usuario usuario){
		//Chamado pelo AspectoCadastrar
	}
	
	private boolean existeCurso(int codCurso){
		
		return buscaPorCodigo(codCurso,"curso");
	}
	
	private boolean existeDepto(int codDpto){
		
		return buscaPorCodigo(codDpto,"departamento");
	}
	
	
	private boolean buscaPorCodigo(int codigo, String nomeTabela){
		
		return true;
	}

}
