package com.ufrpe.ava.gui.controladores;

import com.ufrpe.ava.dados.entidades.Usuario;
import com.ufrpe.ava.util.Tela;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Login extends Tela {
    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoSenha;

    @FXML
    private Button botaoEsqueciSenha;

    public void botaoEntrarAction() {
        System.out.println("CPF: " + campoCPF.getText());
        System.out.println("Senha: " + campoSenha.getText());

        if (campoCPF.getText().length() > 0 && campoSenha.getText().length() > 0) {
            Usuario usuario = this.avaFachada.getCadastroUsuario().login(campoCPF.getText(), campoSenha.getText());
            if (usuario != null) {
                System.out.println(usuario.getNome());
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login inválido");
                alert.setHeaderText("CPF ou senha inválido");

                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos obrigatórios");
            alert.setHeaderText("Por favor preencher o CPF e a senha");

            alert.showAndWait();
        }
    }

    public void botaoEsqueciSenhaAction() {
        System.out.println("Esqueci a senha");

//        try {
//            Parent root = FXMLLoader.load(getClass().getResource("../telas/inicio.fxml"));
//            Scene scene = new Scene(root);
//            Stage stage = (Stage) botaoEsqueciSenha.getScene().getWindow();
//            stage.setScene(scene);
//            stage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
