package com.ot1.kayttoliittyma;

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
    private ChoiceBox asiakasChoiceBox;
    @FXML
    private ChoiceBox mokkiChoiceBox;
    @FXML
    private ChoiceBox paivatChoiceBox;
    @FXML
    private ChoiceBox loppusiivousChoiceBox;

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

    //Eräpäicä datepicker toimimaan
    @FXML
    private void handleEraPaiva() {
        LocalDate eraPaiva = laskuErapaivaDatePicker.getValue();
        System.out.println("Eräpäivä: " + eraPaiva);
    }

}
