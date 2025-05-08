package com.ot1.kayttoliittyma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

public class AlkuNayttoUIController {

    public void mokkienhallintaButton(javafx.event.ActionEvent actionEvent) {

        try {
            System.out.println("Klikkasit mökkienhallintanäppäintä!");
            FXMLLoader fxmlLoader = new
            FXMLLoader(getClass().getResource("/ui/MokkienHallintaUI.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene mokkienhallintaScene = new Scene(root);
            uusiIkkuna.setScene(mokkienhallintaScene);
            uusiIkkuna.setTitle("Mökkien hallinta");
            uusiIkkuna.show();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void majoitusvarauksetButton(ActionEvent actionEvent) {
        System.out.println("Klikkasit majoitusvarausnäppäintä!");
    }

    public void asiakashallintaButton(ActionEvent actionEvent) {
        System.out.println("Klikkasit asiakashallintanäppäintä!");
    }

    public void laskutmetodiButton(ActionEvent actionEvent) {
        System.out.println("Klikkasit laskut-näppäintä!");
    }
}
