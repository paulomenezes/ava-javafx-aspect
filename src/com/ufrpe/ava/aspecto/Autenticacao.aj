package com.ufrpe.ava.aspecto;

import com.ufrpe.ava.negocio.classes_basicas.Usuario;
import com.ufrpe.ava.util.Alertas;
import com.ufrpe.ava.util.Funcoes;

/**
 * Created by paulomenezes on 22/11/15.
 */
public aspect Autenticacao {
    pointcut validarCadastroUsuario(String cpf, String senha, String nome, String email):
        execution(Usuario com.ufrpe.ava.negocio.CadastroUsuario.cadastrarUsuario(String, String, String, String)) && args(cpf, senha, nome, email);

    Usuario around(String cpf, String senha, String nome, String email): validarCadastroUsuario(cpf, senha, nome, email) {
        if (cpf.length() > 0 && senha.length() > 0 && nome.length() > 0 && email.length() > 0) {
            if (Funcoes.validarCPF(cpf)) {
                if (Funcoes.validarEmail(email)) {
                    return proceed(cpf, senha, nome, email);
                } else {
                    Alertas.campoInvalido("Digite um e-mail válido.");
                    return null;
                }
            } else {
                Alertas.campoInvalido("Digite um CPF válido.");
                return null;
            }
        } else {
            Alertas.campoObrigatorio("Por favor, preencha todos os campos.");
            return null;
        }
    }
}
