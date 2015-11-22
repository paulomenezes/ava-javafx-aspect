package com.ufrpe.ava.aspecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by paulomenezes on 20/11/15.
 */
public abstract aspect PersistenciaMySQL {
    static Connection connection = getConnection();

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ava", "root", "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public ResultSet procurar(String tabela, int id) {
        ResultSet resultSet = null;

        try {
            int a = 1;
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ? WHERE id = ?");
            preparedStatement.setString(a, tabela);
            preparedStatement.setInt(2, id);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultSet;
    }
}
