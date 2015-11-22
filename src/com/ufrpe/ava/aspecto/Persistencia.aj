package com.ufrpe.ava.aspecto;

import java.sql.Connection;

/**
 * Created by paulomenezes on 21/11/15.
 */
public aspect Persistencia extends PersistenciaMySQL {
    Connection conexao = getConnection();

    
}
