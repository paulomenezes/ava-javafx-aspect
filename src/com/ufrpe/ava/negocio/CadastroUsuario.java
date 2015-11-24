package com.ufrpe.ava.negocio;

import com.ufrpe.ava.dados.Repositorio;
import com.ufrpe.ava.dados.entidades.Usuario;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class CadastroUsuario {
    private Repositorio<Usuario> usuarioRepositorio = new Repositorio<>();

    public Usuario login(String cpf, String senha) {
        Usuario usuario = usuarioRepositorio.getLista().stream().filter(i ->
                i.getCPF().equals(cpf) && i.getSenha().equals(senha)
        ).findFirst().orElse(null);

        return usuario;
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
}
