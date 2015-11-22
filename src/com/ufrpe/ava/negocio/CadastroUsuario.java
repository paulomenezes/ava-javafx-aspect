package com.ufrpe.ava.negocio;

import com.ufrpe.ava.dados.Repositorio;
import com.ufrpe.ava.dados.entidades.Usuario;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class CadastroUsuario {
    private Repositorio<Usuario> usuarioRepositorio = new Repositorio<>();

    public Usuario login(String cpf, String senha) {
        Usuario usuario = usuarioRepositorio.getLista().stream().filter(u ->
                u.getCPF().equals(cpf) && u.getSenha().equals(senha)
        ).findFirst().orElse(null);

        return usuario;
    }
}
