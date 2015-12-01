package com.ufrpe.ava.negocio;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoJaExistenteExcepitions;
import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;
import com.ufrpe.ava.negocio.classes_basicas.Usuario;
import com.ufrpe.ava.negocio.controladores.ControladorUsuario;

public class AvaFachada implements IAvaFachada {
    private ControladorUsuario controladorUsuario;

    public AvaFachada() {
        controladorUsuario = new ControladorUsuario();
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


	@Override
	public void cadastrarAluno(String nome, String cpf, String email, String senha, int codCurso, String tipo,
			int grad) throws Exception, ObjetoNaoExistenteExcepitions, ObjetoJaExistenteExcepitions {
		// TODO Auto-generated method stub
		controladorUsuario.cadastrarAluno(nome, cpf, email, senha, codCurso, tipo, grad);
	}


	@Override
	public void cadastarProfessor(String nome, String cpf, String email, String senha, int idDepartamento,
			int grad) throws Exception, ObjetoNaoExistenteExcepitions, ObjetoJaExistenteExcepitions {
		
		controladorUsuario.cadastrarProfessor(nome, cpf, email, senha, idDepartamento, grad);
	}

     
}
