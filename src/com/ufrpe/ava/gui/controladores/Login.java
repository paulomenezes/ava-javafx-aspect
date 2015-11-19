package com.ufrpe.ava.gui.controladores;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Login {
    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoSenha;

    @FXML
    private Button botaoEsqueciSenha;

    public void botaoEntrarAction() {
        System.out.println("CPF: " + campoCPF.getText());
        System.out.println("Senha: " + campoSenha.getText());
    }

    public void botaoEsqueciSenhaAction() {
        System.out.println("Esqueci a senha");

        try {
            Parent root = FXMLLoader.load(getClass().getResource("../telas/inicio.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) botaoEsqueciSenha.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
