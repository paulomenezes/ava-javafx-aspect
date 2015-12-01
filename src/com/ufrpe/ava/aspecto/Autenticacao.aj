package com.ufrpe.ava.aspecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ufrpe.ava.negocio.classes_basicas.Usuario;
import com.ufrpe.ava.negocio.controladores.ControladorUsuario;
/**
 * Created by paulomenezes on 22/11/15.
 */
public aspect Autenticacao extends ConnectMySQL {
   
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	//VALIDACAO DE CAMPOS
	pointcut validarCampos(ArrayList<String>campos) : call(* *.validarCampos(..)) && args(campos); 
	pointcut validarSenha(String s1, String s2) : call(* *.validarSenha(..)) && args(s1,s2);
	pointcut validarCpf(String cpf) : call(* *.validarCpf(..)) && args(cpf);
    pointcut validarEmail(String email) : call(* *.validarEmail(..)) && args(email);
    
    pointcut loginUsuario(String cpf, String senha): 
    	call(* ControladorUsuario.buscarUsuario(String, String)) && args(cpf, senha);

    
    
    Usuario around(String cpf, String senha): loginUsuario(cpf, senha) {
 
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
            
        	System.out.println(e.getMessage());
            return null;
        }
    }

    
    boolean around(ArrayList<String>campos): validarCampos(campos) {
    	
    	Boolean retorno = true;
    	
    	for (String string : campos) {
			
    		if(string.length()==0){
    			
    			retorno = false;
    		}
		} 
		 
		return retorno;
    }
    
    
    boolean around(String s1 , String s2): validarSenha(s1,s2){
	    
		 Boolean retorno = false;
		 
		 if(s1.equals(s2)){
			 
			 retorno = true;
		 }
		 
		 return retorno;
	 }
    
    boolean around(String email) : validarEmail(email) {
        if ((email == null) || (email.trim().length() == 0))
            return false;

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
     
     boolean around(String cpf) : validarCpf(cpf){
    	 
    	 return true;
     }
    
}
