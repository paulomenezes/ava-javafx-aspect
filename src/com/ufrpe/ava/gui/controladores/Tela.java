package com.ufrpe.ava.gui.controladores;

import java.io.IOException;
import java.util.ArrayList;

import com.ufrpe.ava.negocio.AvaFachada;
import com.ufrpe.ava.negocio.IAvaFachada;
import com.ufrpe.ava.negocio.entidades.Usuario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class Tela extends Application {
	public IAvaFachada avaFachada = new AvaFachada();
	public Usuario usuarioAtivo;
	
    public void trocarTela(String tela, Button botao) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../telas/" + tela + ".fxml"));
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
			root = FXMLLoader.load(getClass().getResource("../telas/login.fxml"));
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root, 400, 300));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		launch(args);
	}

	public boolean validarCpf(String cpf) {
		return true;
	}

	public boolean validarEmail(String email) {
		return true;
	}

	public boolean validarCampos(ArrayList<String> lista){
		return true;
	}

	public boolean validarSenha(String s1, String s2){
		return true;
	}
}
