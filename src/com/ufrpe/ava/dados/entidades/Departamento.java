package com.ufrpe.ava.dados.entidades;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class Departamento extends Entidade {
    private String nome;
    private int codigo;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
}
