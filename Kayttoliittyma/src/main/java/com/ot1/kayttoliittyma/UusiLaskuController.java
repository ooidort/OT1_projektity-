package com.ot1.kayttoliittyma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class UusiLaskuController {

    @FXML
    private DatePicker laskuPaivamaaraDatePicker;
    @FXML
    private DatePicker laskuErapaivaDatePicker;
    @FXML
    private ChoiceBox <String> asiakasChoiceBox;
    @FXML
    private ChoiceBox <String >mokkiChoiceBox;
    @FXML
    private ChoiceBox <String> paivatChoiceBox;
    @FXML
    private ChoiceBox <String> loppusiivousChoiceBox;

    @FXML
    private void initialize() {
        ObservableList<String> asiakasLista = FXCollections.observableArrayList("Asiakas 1", "Asiakas 2", "Asiakas 3");
        ObservableList<String> mokkiLista = FXCollections.observableArrayList("Mökki1", "Mökki 2", "Mökki 3");
        ObservableList<String> paivatLista = FXCollections.observableArrayList("1", "2", "3");
        ObservableList<String> loppusiivousLista = FXCollections.observableArrayList("0", "1", "2");

        asiakasChoiceBox.setValue("Asiakas 1");
        asiakasChoiceBox.setItems(asiakasLista);

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

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Toiminto takaisin-buttonille
    public void takaisinButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/Alkunaytto.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene takaisinScene = new Scene(root);
            uusiIkkuna.setScene(takaisinScene);
            uusiIkkuna.setTitle("Mökkitie");
            uusiIkkuna.show();

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
    //Asiakas choiceBox toimimaan
    @FXML
    private void handleAsiakasCB() {
        String valittuAsiakas = asiakasChoiceBox.getValue();
        System.out.println("Valittu asiakas: " + valittuAsiakas);
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

}
