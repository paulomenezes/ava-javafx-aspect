package com.ufrpe.ava.dados;

import com.ufrpe.ava.dados.entidades.Entidade;

import java.util.ArrayList;

/**
 * Created by paulomenezes on 18/11/15.
 */
public class Repositorio<E extends Entidade> {
    protected ArrayList<E> lista = new ArrayList<>();

    public ArrayList<E> getLista() {
        return lista;
    }

    public void inserir(E item) {
        lista.add(item);
    }

    public void atualizar(E item) {
        for (int i = 0; i < lista.size(); i++)
            if (lista.get(i).getId() == item.getId())
                lista.set(i, item);
    }

    public E procurar(int id) {
        for (int i = 0; i < lista.size(); i++)
            if (lista.get(i).getId() == id)
                return lista.get(i);

        return null;
    }

    public void deletar(E item) {
        for (int i = 0; i < lista.size(); i++)
            if (lista.get(i).getId() == item.getId())
                lista.remove(i);
    }
}
