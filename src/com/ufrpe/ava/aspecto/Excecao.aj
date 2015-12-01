package com.ufrpe.ava.aspecto;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;

import javafx.scene.control.Alert;

/**
 * Created by paulomenezes on 25/11/15.
 */
public aspect Excecao extends ConnectMySQL {
	
	pointcut notExistException() : call(* *.buscar*(..));
	
	
	after()throwing(ObjetoNaoExistenteExcepitions e): notExistException(){
		
		 Alert alert = new Alert(Alert.AlertType.INFORMATION);
         alert.setTitle("Atenção!!");
         alert.setHeaderText(e.getMessage());
         alert.showAndWait();	
	}
	
	
}
