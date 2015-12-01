package com.ufrpe.ava.aspecto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.ufrpe.ava.negocio.classes_basicas.Usuario;
import com.ufrpe.ava.negocio.controladores.ControladorUsuario;

public aspect Cadastro extends ConnectMySQL {
	
	pointcut inserirUsuario(Usuario usuario): call(* ControladorUsuario.cadastrarUsuario(..)) && args(usuario)  ;
    
	pointcut selecionarTudo(): execution(* ControladorUsuario.selecionarTudo());
    
  
    ArrayList<Usuario> around(): selecionarTudo() {
        
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

     void around(Usuario usuario): inserirUsuario(usuario) {
    	
    	   try{  
    		   		PreparedStatement statement = connection.prepareStatement("SELECT * FROM ");
    		   
    	   }catch(Exception e){
    		   
    		   
    	   }
    	   	
    }
        

}
