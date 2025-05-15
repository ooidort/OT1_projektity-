package com.ot1.kayttoliittyma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;

import javax.security.auth.login.AccountNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

public class AlkuNayttoUIController {
    @FXML
    private Button laskutButton;
    @FXML
    private Button mokitButton;
    @FXML
    private Button asiakasButton;
    @FXML
    private Button varauksetButton;

    public void mokkienhallintaButton(javafx.event.ActionEvent actionEvent) {

        try {
            MokitDAO mokitdao = new MokitDAO();

            MokkiLuokka haetttuMokki = mokitdao.getMokki(1);
            if (haetttuMokki != null) {
                System.out.println("Hait seuraavan mökin tiedot: " + " " + haetttuMokki.getMokkiID() +
                        haetttuMokki.getOsoite() + " " + haetttuMokki.getHinta());
            } else {
                System.out.println("Mökkiä ei löytynyt!");
            }

            System.out.println("Klikkasit mökkienhallintanäppäintä!");
            FXMLLoader fxmlLoader = new
            FXMLLoader(getClass().getResource("/ui/MokkienHallintaUI.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene mokkienhallintaScene = new Scene(root);
            uusiIkkuna.setScene(mokkienhallintaScene);
            uusiIkkuna.setTitle("Mökkien hallinta");
            uusiIkkuna.show();

            Stage stage = (Stage) mokitButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void majoitusvarauksetButton(ActionEvent actionEvent) {
        try{
            System.out.println("Klikkasit majoitusvarausnäppäintä!");
            FXMLLoader fxmlLoader = new FXMLLoader
                    (getClass().getResource("/ui/MajoitusvarausUI.fxml"));
            Parent root = fxmlLoader.load();
            Stage varausIkkuna = new Stage();
            Scene majoitusVarauksetScene = new Scene(root);
            varausIkkuna.setTitle("Majoitusvaraukset");
            varausIkkuna.setScene(majoitusVarauksetScene);
            varausIkkuna.show();

            Stage stage = (Stage) varauksetButton.getScene().getWindow();
            stage.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void asiakashallintaButton(ActionEvent actionEvent) {
        System.out.println("Klikkasit asiakashallintanäppäintä!");
    }

    public void laskutmetodiButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/laskut.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene laskutScene = new Scene(root);
            uusiIkkuna.setScene(laskutScene);
            uusiIkkuna.setTitle("Laskujen hallinta");
            uusiIkkuna.show();

            Stage stage = (Stage) laskutButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
