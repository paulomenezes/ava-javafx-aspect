package com.ufrpe.ava.negocio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AvaFachada extends Application {
    private CadastroUsuario cadastroUsuario;

    public AvaFachada() {
        cadastroUsuario = new CadastroUsuario();
    }

    public CadastroUsuario getCadastroUsuario() {
        return cadastroUsuario;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../gui/telas/login.fxml"));
        primaryStage.setTitle("Login");
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
