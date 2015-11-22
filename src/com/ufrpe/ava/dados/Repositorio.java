package com.ufrpe.ava.dados;

import com.ufrpe.ava.dados.entidades.Entidade;

import java.util.ArrayList;

/**
 * Created by paulomenezes on 18/11/15.
 */
public class Repositorio<E extends Entidade> {
    protected ArrayList<E> lista = new ArrayList<>();

    public Repositorio() {

    }

    public ArrayList<E> getLista() {
        return lista;
    }

    public E inserir(E item) {

        return null;
    }

    public boolean atualizar(E item) {
        return true;
    }

    public E procurar(int id) {
        return null;
    }

    public boolean deletar(E item) {
        return true;
    }
}
