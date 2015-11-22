package com.ufrpe.ava.dados.entidades;

import java.util.Date;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class Entidade {
    protected int id;
    protected Date dataCriacao;
    protected Date dataAtualizacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
