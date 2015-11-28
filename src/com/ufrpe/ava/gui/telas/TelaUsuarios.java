package com.ufrpe.ava.gui.telas;

import java.util.List;

import com.ufrpe.ava.dados.entidades.Usuario;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Created by paulomenezes on 27/11/15.
 */
public class TelaUsuarios extends Tela {
    @FXML
    private TableView<Usuario> tabela;
    @FXML
    private TableColumn<Usuario, String> nome;
    @FXML
    private TableColumn<Usuario, String> email;
    @FXML
    private TableColumn<Usuario, String> foto;
    @FXML
    private TableColumn<Usuario, String> cpf;

    @SuppressWarnings("unchecked")
	@FXML
    private void initialize() {
        List<Usuario> usuarios = this.avaFachada.selecionarTudo();
        if (usuarios != null) {
            tabela.setItems(FXCollections.observableArrayList(usuarios));

            nome = new TableColumn<>("Nome");
            nome.setCellValueFactory(new PropertyValueFactory<Usuario, String>("nome"));

            email = new TableColumn<>("E-maill");
            email.setCellValueFactory(new PropertyValueFactory<Usuario, String>("email"));

            foto = new TableColumn<>("Foto");
            foto.setCellValueFactory(new PropertyValueFactory<Usuario, String>("foto"));

            cpf = new TableColumn<>("CPF");
            cpf.setCellValueFactory(new PropertyValueFactory<Usuario, String>("cpf"));

            tabela.getColumns().addAll(nome, email, foto, cpf);
        } else {
            System.out.println("Usuarios null");
        }
    }
}
