package com.ot1.kayttoliittyma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class LaskunMuokkausIkkunaController {
    @FXML
    private Button takaisinButton;
    @FXML
    private Button kotiButton;
    @FXML
    private Button tallennaButton;
    @FXML
    private Button poistaLaskuButton;
    @FXML
    private DatePicker laskuPaivamaaraDatePicker;
    @FXML
    private DatePicker laskuErapaivaDatePicker;
    @FXML
    private ChoiceBox <String >mokkiChoiceBox;
    @FXML
    private ChoiceBox <String> paivatChoiceBox;
    @FXML
    private ChoiceBox <String> loppusiivousChoiceBox;

    @FXML
    private void initialize() {
        ObservableList<String> mokkiLista = FXCollections.observableArrayList("Mökki1", "Mökki 2", "Mökki 3");
        ObservableList<String> paivatLista = FXCollections.observableArrayList("1", "2", "3");
        ObservableList<String> loppusiivousLista = FXCollections.observableArrayList("0", "1", "2");

        mokkiChoiceBox.setValue("Mökki 1");
        mokkiChoiceBox.setItems(mokkiLista);

        paivatChoiceBox.setValue("1");
        paivatChoiceBox.setItems(paivatLista);

        loppusiivousChoiceBox.setValue("0");
        paivatChoiceBox.setItems(loppusiivousLista);
    }
    //Toiminto koti-buttonille
    public void kotiButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/AlkuNaytto.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene kotiButtonScene = new Scene(root);
            uusiIkkuna.setScene(kotiButtonScene);
            uusiIkkuna.setTitle("Mökkitie");
            uusiIkkuna.show();

            Stage stage = (Stage) kotiButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Toiminto takaisin-buttonille
    public void takaisinButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/MuokkaaJaPoistaLaskuja.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene takaisinScene = new Scene(root);
            uusiIkkuna.setScene(takaisinScene);
            uusiIkkuna.setTitle("Mökkitie");
            uusiIkkuna.show();

            Stage stage = (Stage) takaisinButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Päivämäärä datepicker toimimaan
    @FXML
    private void handleAloitusPaiva() {
        LocalDate aloitusPaiva = laskuPaivamaaraDatePicker.getValue();
        System.out.println("Aloituspäivä: " + aloitusPaiva);
    }

    //Eräpäivä datepicker toimimaan
    @FXML
    private void handleEraPaiva() {
        LocalDate eraPaiva = laskuErapaivaDatePicker.getValue();
        System.out.println("Eräpäivä: " + eraPaiva);
    }

    //Mökki choiceBox toimimaan
    @FXML
    private void handleMokkiCB() {
        String valittuMokki = mokkiChoiceBox.getValue();
        System.out.println("Valittu mökki: " + valittuMokki);
    }

    //Majoitettujen päivien määrä toimimaan
    @FXML
    private void handlePaivatCB() {
        String valitutPaivat = paivatChoiceBox.getValue();
        System.out.println("Päivien määrä: " + valitutPaivat);
    }

    //Loppusiivous choiceBox toimiaan
    @FXML
    private void handleLoppusiivousCB() {
        String loppusiivous = loppusiivousChoiceBox.getValue();
        System.out.println("Loppusiivous: " + loppusiivous);
    }

    //Tallenna button toimimaan
    @FXML
    private void handleTallennaBt() {
        //Tallentaa tiedot tietokantaan

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/MuokkaaJaPoistaLaskuja.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene takaisinScene = new Scene(root);
            uusiIkkuna.setScene(takaisinScene);
            uusiIkkuna.setTitle("Muokkaa ja poista laskuja");
            uusiIkkuna.show();

            Stage stage = (Stage) takaisinButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Poista lasku button toimimaan
    @FXML
    private void handlePoistaLaskuBt() {
        //Poistaa laskun
        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/MuokkaaJaPoistaLaskuja.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene takaisinScene = new Scene(root);
            uusiIkkuna.setScene(takaisinScene);
            uusiIkkuna.setTitle("Muokkaa ja poista laskuja");
            uusiIkkuna.show();

            Stage stage = (Stage) takaisinButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
