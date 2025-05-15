package com.ot1.kayttoliittyma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MuokkaaLaskujaController {
    @FXML
    private Button haeLaskuja;
    @FXML
    private Button kotiButtonM;
    @FXML
    private Button takaisinButtonM;
    @FXML
    private ChoiceBox <String> valitseAsiakasCB;
    @FXML
    private ChoiceBox<String> valitseLaskuCB;


    @FXML
    private void initialize() {
        ObservableList<String> asiakasLista = FXCollections.observableArrayList("Asiakas 1", "Asiakas 2", "Asiakas 3");
        ObservableList<String> laskuLista = FXCollections.observableArrayList("Lasku 1", "Lasku 2", "Lasku 3");

        valitseAsiakasCB.setValue("Asiakas 1");
        valitseAsiakasCB.setItems(asiakasLista);

        valitseLaskuCB.setItems(laskuLista);
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
    //Toiminto hae laskuja napille
    public void haeLaskujaBt (javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/LaskunMuokkausIkkuna.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene takaisinScene = new Scene(root);
            uusiIkkuna.setScene(takaisinScene);
            uusiIkkuna.setTitle("Muokkaa tai poista laskuja");
            uusiIkkuna.show();

            Stage stage = (Stage) haeLaskuja.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //Asiakas choiceBox toimimaan
    @FXML
    private void handleAsiakasCB() {
        String valittuAsiakas = valitseAsiakasCB.getValue();
        System.out.println("Valittu asiakas: " + valittuAsiakas);
    }

    //Valitse lasku choiceBox toimimaan
    @FXML
    private void handleValitseLaskuCB() {
        String valittuLasku = valitseLaskuCB.getValue();
    }


}
