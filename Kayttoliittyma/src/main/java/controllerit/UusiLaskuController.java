package controllerit;

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
import tietokantahaut.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;

public class UusiLaskuController {
    @FXML
    private Button takaisinButton;
    @FXML
    private Button kotiButton;
    @FXML
    private Button tallennaButton;
    @FXML
    private DatePicker laskuPaivamaaraDatePicker;
    @FXML
    private DatePicker laskuErapaivaDatePicker;
    @FXML
    private ChoiceBox<AsiakasLuokka> asiakasChoiceBox;
    @FXML
    private ChoiceBox <MokkiLuokka>mokkiChoiceBox;
    @FXML
    private ChoiceBox <Integer> paivatChoiceBox;
    @FXML
    private ChoiceBox <String> loppusiivousChoiceBox;

    @FXML
    private void initialize() {
        //ObservableList<String> asiakasLista = FXCollections.observableArrayList("Asiakas 1", "Asiakas 2", "Asiakas 3");
        //ObservableList<String> mokkiLista = FXCollections.observableArrayList("Mökki1", "Mökki 2", "Mökki 3", "Mökki 4");

        ObservableList<Integer> paivatLista = FXCollections.observableArrayList(1, 2, 3, 4, 5, 6,7,8,9, 10);
        ObservableList<String> loppusiivousLista = FXCollections.observableArrayList("Ei", "Kyllä");

        AsiakasDAO asiakasDAO = new AsiakasDAO();
        ObservableList<AsiakasLuokka> asiakkaat = asiakasDAO.haeKaikkiAsiakkaat();
        asiakasChoiceBox.setItems(asiakkaat);

        // Mökit
        MokitDAO mokkiDAO = new MokitDAO();
        ObservableList<MokkiLuokka> mokit = mokkiDAO.haeKaikkiMokit();
        mokkiChoiceBox.setItems(mokit);

        asiakasChoiceBox.setItems(asiakkaat);

        mokkiChoiceBox.setItems(mokit);

        paivatChoiceBox.setItems(paivatLista);

        loppusiivousChoiceBox.setItems(loppusiivousLista);
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
                    FXMLLoader(getClass().getResource("/ui/laskut.fxml"));
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
    @FXML
    private void handleTallennaBt() {
        try {
            // Hae päivämäärät
            LocalDate paiva = laskuPaivamaaraDatePicker.getValue();
            LocalDate erapaiva = laskuErapaivaDatePicker.getValue();

            if (paiva == null || erapaiva == null) {
                System.out.println("Päivämäärä tai eräpäivä puuttuu.");
                return;
            }

            Timestamp paivamaaraTimestamp = Timestamp.valueOf(paiva.atStartOfDay());
            Timestamp erapaivaTimestamp = Timestamp.valueOf(erapaiva.atStartOfDay());

            // Hae asiakas
            AsiakasLuokka valittuAsiakas = asiakasChoiceBox.getValue();
            if (valittuAsiakas == null) {
                System.out.println("Asiakasta ei valittu.");
                return;
            }

            // Hae mökki
            MokkiLuokka valittuMokki = mokkiChoiceBox.getValue();
            if (valittuMokki == null) {
                System.out.println("Mökkiä ei valittu.");
                return;
            }

            // Hae päivien määrä
            Integer paivienMaara = paivatChoiceBox.getValue();
            if (paivienMaara == null) {
                System.out.println("Päivien määrää ei valittu.");
                return;
            }

            // Hae loppusiivous
            Boolean loppusiivous = Boolean.valueOf(loppusiivousChoiceBox.getValue());
            if (loppusiivous == null) {
                System.out.println("Loppusiivousta ei valittu.");
                return;
            }

            // Laske hinta
            int kokonaishinta = valittuMokki.getHinta() * paivienMaara;
            if (loppusiivous) {
                kokonaishinta += 50;
            }

            // Luo uusi lasku tietokantaan DAO:n kautta
            LaskuDAO laskuDAO = new LaskuDAO();
            laskuDAO.lisaaLasku(paivamaaraTimestamp, erapaivaTimestamp, valittuAsiakas.getAsiakasID(),
                    valittuMokki.getMokkiID(), kokonaishinta, loppusiivous);

            System.out.println("Lasku tallennettu!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
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
        AsiakasLuokka valittuAsiakas = asiakasChoiceBox.getValue();
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
    //Tallenna button toimimaan
    @FXML
    private void handleTallennaBt() {
        //Tallentaa tiedot tietokantaan

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/laskut.fxml"));
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
    **/

}
