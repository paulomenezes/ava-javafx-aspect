package com.ufrpe.ava.aspecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

public abstract aspect ConnectMySQL {

	 public static Connection connection = getConnection();

	    public static Connection getConnection() {
	        if (connection == null) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver");
	                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ava", "root", "34519687");
	            } catch (Exception e) {
	                
	            	System.out.println("Conexão com o banco falhou");
	            }
	        }

	        return connection;
	    }

	    public void inserir(String tabela, HashMap<String, Object> nomeValor) {
	        try {
	            String colunas = "";
	            String camposQuantidade = "";

	            int i = 1;
	            for (Map.Entry<String, Object> item : nomeValor.entrySet()) {
	                String nome = item.getKey().replace("get", "").toLowerCase();
	                colunas +=  i == nomeValor.size() ? nome : nome + ", ";
	                camposQuantidade +=  i == nomeValor.size() ? "?" : "?, ";
	                i++;
	            }

	            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO " + tabela + " (" + colunas + ") VALUES (" + camposQuantidade + ")");

	            i = 1;
	            for (Map.Entry<String, Object> item : nomeValor.entrySet()) {
	                if (item.getValue() instanceof String)
	                    preparedStatement.setString(i, (String)item.getValue());
	                else if (item.getValue() instanceof Integer)
	                    preparedStatement.setInt(i, (int)item.getValue());
	                else if (item.getValue() instanceof Float)
	                    preparedStatement.setFloat(i, (float)item.getValue());

	                i++;
	            }
	            preparedStatement.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
