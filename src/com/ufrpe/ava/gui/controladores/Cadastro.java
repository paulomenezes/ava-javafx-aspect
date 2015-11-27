package com.ufrpe.ava.gui.controladores;

import com.ufrpe.ava.util.Tela;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by paulomenezes on 22/11/15.
 */
public class Cadastro extends Tela {
    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoSenha;

    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoEmail;

    @FXML
    private Button botaoVoltar;

    @FXML
    private Button botaoCriarConta;

    public void botaoVoltarAction() {
        trocarTela("login", botaoVoltar);
    }

    public void botaoCriarContaAction() {
        System.out.println("Criar conta");

        if (this.avaFachada.getCadastroUsuario().cadastrarUsuario(campoCPF.getText(), campoSenha.getText(), campoNome.getText(), campoEmail.getText()) != null) {
            trocarTela("telaUsuarios", botaoCriarConta);
        }
    }
}
