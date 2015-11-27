package com.ufrpe.ava.negocio;

import com.ufrpe.ava.dados.RepositorioUsuario;
import com.ufrpe.ava.dados.entidades.Usuario;

import java.util.ArrayList;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class CadastroUsuario {
    private RepositorioUsuario usuarioRepositorio = new RepositorioUsuario();

    public Usuario login(String cpf, String senha) {
        return null;
    }

    public Usuario cadastrarUsuario(String cpf, String senha, String nome, String email) {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCPF(cpf);
        usuario.setEmail(email);
        usuario.setSenha(senha);

        usuarioRepositorio.inserir(usuario);

        return usuario;
    }

    public ArrayList<Usuario> selecionarTudo() {
        return null;
    }
}
