package com.ufrpe.ava.negocio.classes_basicas;

	/**
	 * Created by paulomenezes on 20/11/15.
	 */
	public class Usuario extends Entidade {
	    private String CPF;
	    private String nome;
	    private String email;
	    private String foto;
	    private String senha;

	    public String getCPF() {
	        return CPF;
	    }

	    public void setCPF(String CPF) {
	        this.CPF = CPF;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getFoto() {
	        return foto;
	    }

	    public void setFoto(String foto) {
	        this.foto = foto;
	    }

	    public String getSenha() {
	        return senha;
	    }

	    public void setSenha(String senha) {
	        this.senha = senha;
	    }
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((CPF == null) ? 0 : CPF.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			Usuario other = (Usuario) obj;
			if (CPF == null) {
				if (other.CPF != null)
					return false;
			} else if (!CPF.equals(other.CPF))
				return false;
			return true;
		}

	}

