package com.ufrpe.ava.util;

import com.ufrpe.ava.negocio.AvaFachada;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by paulomenezes on 20/11/15.
 */
public class Tela {
    public AvaFachada avaFachada = new AvaFachada();

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
}
