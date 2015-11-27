package com.ufrpe.ava.aspecto;

import com.ufrpe.ava.dados.entidades.Entidade;
import com.ufrpe.ava.dados.entidades.Usuario;

import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by paulomenezes on 21/11/15.
 */
public aspect Persistencia extends PersistenciaMySQL {
    pointcut inserir(): execution(* com.ufrpe.ava.negocio.CadastroUsuario.cadastrarUsuario(..));
    pointcut selecionarTudo(): call(* com.ufrpe.ava.negocio.CadastroUsuario.selecionarTudo());

    pointcut loginUsuario(String cpf, String senha): call(* com.ufrpe.ava.negocio.CadastroUsuario.login(String, String)) && args(cpf, senha);

    Usuario around(String cpf, String senha): loginUsuario(cpf, senha) {
        System.out.println("login");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario WHERE cpf = ? and senha = ?");
            statement.setString(1, cpf);
            statement.setString(2, senha);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                //usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCPF(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setFoto(resultSet.getString("foto"));

                System.out.println(usuario.getNome());

                return usuario;
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    ArrayList<Usuario> around(): selecionarTudo() {
        System.out.println("selecionar tudo");
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario");
            ResultSet resultSet = statement.executeQuery();

            ArrayList<Usuario> lista = new ArrayList<>();
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                //usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setCPF(resultSet.getString("cpf"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setFoto(resultSet.getString("foto"));

                lista.add(usuario);
            }

            return lista;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    after() returning(Entidade item): inserir() {
        System.out.println("Before insert");
        System.out.println(item);

        String[] nome = item.getClass().getName().toLowerCase().split("\\.");

        Method[] methods = item.getClass().getMethods();
        HashMap<String, Object> nomeValor = new HashMap<>();

        try {
            for (int i = 0; i < methods.length; i++) {
                if (methods[i].getName().startsWith("get") &&
                        !methods[i].getName().equals("getId") &&
                        !methods[i].getName().equals("getClass")) {

                    if (methods[i].invoke(item, new Object[]{}) != null) {
                        nomeValor.put(methods[i].getName(), methods[i].invoke(item, new Object[]{}));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        inserir(nome[nome.length - 1], nomeValor);
    }
}
