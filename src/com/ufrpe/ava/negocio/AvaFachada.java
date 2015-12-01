package com.ufrpe.ava.negocio;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.classes_basicas.Aluno;
import com.ufrpe.ava.negocio.classes_basicas.Professor;
import com.ufrpe.ava.negocio.classes_basicas.Usuario;
import com.ufrpe.ava.negocio.controladores.ControladorUsuario;

public class AvaFachada implements IAvaFachada {
    private ControladorUsuario controladorUsuario;

    public AvaFachada() {
        controladorUsuario = new ControladorUsuario();
    }

	@Override
	public Aluno cadastrarAluno(String nome, String cpf,String email, String senha,int codCurso,String tipo,char grad) {
		return null;
	}

	@Override
	public Professor cadastarProfessor(String nome, String cpf,String email, String senha,int idDepartamento,char grad) {
		return null;
	}

	@Override
	public Usuario buscarLogin(String cpf, String senha) throws ObjetoNaoExistenteExcepitions {
		
		Usuario usuario = controladorUsuario.buscarLogin(cpf, senha);
		return usuario;
	}

	@Override
	public ArrayList<Usuario> selecionarTudo() {
		// TODO Auto-generated method stub
		return null;
	}

     
}
