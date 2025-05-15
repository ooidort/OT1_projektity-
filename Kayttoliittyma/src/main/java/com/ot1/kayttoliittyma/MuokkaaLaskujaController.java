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

public class MuokkaaLaskujaController {
    @FXML
    private Button poistaLaskubt;
    @FXML
    private Button kotiButtonM;
    @FXML
    private Button takaisinButtonM;
    @FXML
    private Button tallennaButtonM;
    @FXML
    private DatePicker laskuPaivamaaraDatePickerM;
    @FXML
    private DatePicker laskuErapaivaDatePickerM;
    @FXML
    private ChoiceBox<String> asiakasChoiceBoxM;
    @FXML
    private ChoiceBox <String >mokkiChoiceBoxM;
    @FXML
    private ChoiceBox <String> paivatChoiceBoxM;
    @FXML
    private ChoiceBox <String> loppusiivousChoiceBoxM;


    @FXML
    private void initialize() {
        ObservableList<String> asiakasLista = FXCollections.observableArrayList("Asiakas 1", "Asiakas 2", "Asiakas 3");
        ObservableList<String> mokkiLista = FXCollections.observableArrayList("Mökki1", "Mökki 2", "Mökki 3");
        ObservableList<String> paivatLista = FXCollections.observableArrayList("1", "2", "3");
        ObservableList<String> loppusiivousLista = FXCollections.observableArrayList("0", "1", "2");

        asiakasChoiceBoxM.setValue("Asiakas 1");
        asiakasChoiceBoxM.setItems(asiakasLista);

        mokkiChoiceBoxM.setValue("Mökki 1");
        mokkiChoiceBoxM.setItems(mokkiLista);

        paivatChoiceBoxM.setValue("1");
        paivatChoiceBoxM.setItems(paivatLista);

        loppusiivousChoiceBoxM.setValue("0");
        paivatChoiceBoxM.setItems(loppusiivousLista);
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

            Stage stage = (Stage) kotiButtonM.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Toiminto takaisin-buttonille
    public void takaisinButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/laskut.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene takaisinScene = new Scene(root);
            uusiIkkuna.setScene(takaisinScene);
            uusiIkkuna.setTitle("Laskujen hallinta");
            uusiIkkuna.show();

            Stage stage = (Stage) takaisinButtonM.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Päivämäärä datepicker toimimaan
    @FXML
    private void handleAloitusPaiva() {
        LocalDate aloitusPaiva = laskuPaivamaaraDatePickerM.getValue();
        System.out.println("Aloituspäivä: " + aloitusPaiva);
    }
    //Eräpäivä datepicker toimimaan
    @FXML
    private void handleEraPaiva() {
        LocalDate eraPaiva = laskuErapaivaDatePickerM.getValue();
        System.out.println("Eräpäivä: " + eraPaiva);
    }
    //Asiakas choiceBox toimimaan
    @FXML
    private void handleAsiakasCB() {
        String valittuAsiakas = asiakasChoiceBoxM.getValue();
        System.out.println("Valittu asiakas: " + valittuAsiakas);
    }
    //Mökki choiceBox toimimaan
    @FXML
    private void handleMokkiCB() {
        String valittuMokki = mokkiChoiceBoxM.getValue();
        System.out.println("Valittu mökki: " + valittuMokki);
    }
    //Majoitettujen päivien määrä toimimaan
    @FXML
    private void handlePaivatCB() {
        String valitutPaivat = paivatChoiceBoxM.getValue();
        System.out.println("Päivien määrä: " + valitutPaivat);
    }
    //Loppusiivous choiceBox toimiaan
    @FXML
    private void handleLoppusiivousCB() {
        String loppusiivous = loppusiivousChoiceBoxM.getValue();
        System.out.println("Loppusiivous: " + loppusiivous);
    }
    //Tallenna button toimimaan
    @FXML
    private void handleTallennaBt() {
        //Tallentaa tiedot tietokantaan

        Stage stage = (Stage) tallennaButtonM.getScene().getWindow();
        stage.close();
    }
    //Poista lasku button toimimaan
    @FXML
    private void handlePoistaLaskuBt() {
        //Poistaa laskun

        Stage stage = (Stage) poistaLaskubt.getScene().getWindow();
        stage.close();
    }
}
