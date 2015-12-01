package com.ufrpe.ava.gui.telas;

import java.util.ArrayList;

import com.ufrpe.ava.excecoes.ObjetoNaoExistenteExcepitions;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class TelaLogin extends Tela {
    @FXML
    private TextField campoCPF;

    @FXML
    private TextField campoSenha;

    @FXML
    private Button botaoEsqueciSenha;

    @FXML
    private Button botaoCriarConta;

    public void botaoEntrarAction() {
    	
    	ArrayList<String>listaValidacao = new ArrayList<>();
    	listaValidacao.add(campoCPF.getText());
    	listaValidacao.add(campoSenha.getText());

        if (this.validarCampos(listaValidacao)) {
        		
			try {
				   this.usuarioAtivo = this.avaFachada.buscarLogin(campoCPF.getText(), campoSenha.getText());
				   trocarTela("telaUsuarios", botaoCriarConta);
		           
			} catch (ObjetoNaoExistenteExcepitions e) {
				
				System.out.println(e.getMessage());
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

    public void botaoCriarContaAction() {
        System.out.println("Criar conta");

        trocarTela("cadastro", botaoCriarConta);
    }
    
}
