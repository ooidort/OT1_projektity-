package src.main.java.com.ot1.kayttoliittyma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class LaskutController {
    ObservableList<String> asiakasLista = FXCollections.observableArrayList("Asiakas 1", "Asiakas 2", "Asiakas 3");
    ObservableList<String> mokkiLista = FXCollections.observableArrayList("Mökki1", "Mökki 2", "Mökki 3");
    ObservableList<String> paivatLista = FXCollections.observableArrayList("1", "2", "3");
    ObservableList<String> loppusiivousLista = FXCollections.observableArrayList("0", "1", "2");

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

    @FXML
    private void initialize() {
        asiakasChoiceBox.setValue("Asiakas 1");
        asiakasChoiceBox.setItems(asiakasLista);

        mokkiChoiceBox.setValue("Mökki 1");
        mokkiChoiceBox.setItems(mokkiLista);

        paivatChoiceBox.setValue("1");
        paivatChoiceBox.setItems(paivatLista);

        loppusiivousChoiceBox.setValue("0");
        paivatChoiceBox.setItems(loppusiivousLista);
    }


    public void valitseLaskunPaivamaara () {
        LocalDate valittuPaivamaara = laskuPaivamaaraDatePicker.getValue();
    }

    public void valitseErapaiva () {
        LocalDate valittuErapaiva = laskuErapaivaDatePicker.getValue();
    }

    public void valitseAsiakas () {
    }
    public void valitseMokki () {
    }
    public void valitsePaivat () {
    }
    public void valitseSiivous () {
    }


    public void uusiLaskuButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/UusiLasku.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene uusiLaskuScene = new Scene(root);
            uusiIkkuna.setScene(uusiLaskuScene);
            uusiIkkuna.setTitle("Uusi lasku");
            uusiIkkuna.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void muokkaaLaskujaButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/MuokkaaJaPoistaLaskuja.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene muokkaaLaskujaScene = new Scene(root);
            uusiIkkuna.setScene(muokkaaLaskujaScene);
            uusiIkkuna.setTitle("Muokkaa ja poista laskuja");
            uusiIkkuna.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

}
