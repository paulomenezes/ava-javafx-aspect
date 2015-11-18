package com.ufrpe.ava.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoSenha;

    public void botaoEntrarAction() {
        System.out.println("CPF: " + campoCPF.getText());
        System.out.println("Senha: " + campoSenha.getText());
    }

    public void botaoEsqueciSenhaAction() {
        System.out.println("Esqueci a senha");
    }
}
