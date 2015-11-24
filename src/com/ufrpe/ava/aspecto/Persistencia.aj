package com.ufrpe.ava.aspecto;

import com.ufrpe.ava.dados.entidades.Entidade;

import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by paulomenezes on 21/11/15.
 */
public aspect Persistencia extends PersistenciaMySQL {
    pointcut inserir(Entidade item): call(* com.ufrpe.ava.dados.Repositorio.inserir(Entidade)) && args(item);
    pointcut getLista(): call(* com.ufrpe.ava.dados.Repositorio.getLista());

    before(): getLista() {
        
    }

    before(Entidade item): inserir(item) {
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

        }

        inserir(nome[nome.length - 1], nomeValor);
    }
}
