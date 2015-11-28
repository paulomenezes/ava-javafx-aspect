package com.ufrpe.ava.negocio;

import java.util.ArrayList;

import com.ufrpe.ava.dados.entidades.Usuario;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;

public class AvaFachada implements IAvaFachada {
    private ControladorUsuario controladorUsuario;

    public AvaFachada() {
        controladorUsuario = new ControladorUsuario();
    }

	@Override
	public void cadastrarAluno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastarProfessor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario login(String cpf, String senha) throws ObjetoNaoExistenteExcepitions {
		
		Usuario usuario = controladorUsuario.login(cpf, senha);
		return usuario;
	}

	@Override
	public ArrayList<Usuario> selecionarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object cadastrarUsuario(String text, String text2, String text3, String text4) {
		// TODO Auto-generated method stub
		return null;
	}

     
}
