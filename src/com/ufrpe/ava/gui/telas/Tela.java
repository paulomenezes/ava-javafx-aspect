package com.ufrpe.ava.gui.telas;

import com.ufrpe.ava.negocio.AvaFachada;
import com.ufrpe.ava.negocio.IAvaFachada;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class Tela extends Application {
    public IAvaFachada avaFachada = new AvaFachada();

    public void trocarTela(String tela, Button botao) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(tela + ".fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) botao.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void start(Stage primaryStage){
		 Parent root;
	
			 try {
				root = FXMLLoader.load(getClass().getResource("login.fxml"));
				primaryStage.setTitle("Login");
			    primaryStage.setScene(new Scene(root, 400, 300));
			    primaryStage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
	
	    	
	}
	
	public static void main(String[] args){
		
		launch(args);
	}
	
	
}
