package com.ufrpe.ava.negocio.controladores;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.classes_basicas.Usuario;

public class ControladorUsuario {
	
	
	public Usuario login(String cpf, String senha)throws ObjetoNaoExistenteExcepitions{
		
		Usuario usuario = buscar(cpf,senha);
		 
		if(usuario == null){
			
			throw new ObjetoNaoExistenteExcepitions(cpf);
		}
		
		return usuario;
	}
	
	private Usuario buscar(String cpf, String senha){
		
		return null;
	}
	
	public ArrayList<Usuario> selecionarTudo(){
		
		return null;
	}
	
	

}
