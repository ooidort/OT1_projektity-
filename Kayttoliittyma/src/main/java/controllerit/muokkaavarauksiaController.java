package controllerit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

public class muokkaavarauksiaController implements Initializable {
    @FXML
    private Label alkuPaivaLabel1;

    @FXML
    private DatePicker alkupaivaDate1;

    @FXML
    private TextField asiakasField1;

    @FXML
    private Label asiakasLabel1;

    @FXML
    private TextField lisatietoField1;

    @FXML
    private Label lisatietoLabel1;

    @FXML
    private Label loppuPaivaLabel1;

    @FXML
    private DatePicker loppupaivaDate1;

    @FXML
    private Label mokkiLabel1;

    @FXML
    private ChoiceBox<String> muokkaaChoice;
    private String[] mokit = {"Mökki 1", "Mökki 2", "Mökki 3", "Mökki 4"};

    @FXML
    private Button peruutaBt1;

    @FXML
    private VBox poistaMuokkaavarauksia;

    @FXML
    private Button poistavarausBt;

    @FXML
    private Button tallennavarausBt1;

    @FXML
    private Button kotiButton;

    @FXML
    private Button takaisinButton;

    @FXML
    private Label uusiVaraus1;

    private int parseMokkiID(String mokkiString) {
        try {
            return Integer.parseInt(mokkiString.replaceAll("\\D+", ""));
        } catch (NumberFormatException e) {
            return -1; // Virheellinen syöte
        }
    }

    @FXML
    void tyhjennaKentat() {
        // tekstikenttien tyhjennys
        asiakasField1.clear();
        lisatietoField1.clear();

        // choicebox palautus oletusarvoon
        muokkaaChoice.setValue(null);

        // DatePickerit tyhjennys
        alkupaivaDate1.setValue(null);
        loppupaivaDate1.setValue(null);
    }

    // peruuta -painikkeen toiminta
    @FXML
    void peruutaMuutokset(ActionEvent event) {
        tyhjennaKentat();
        System.out.println("Kentät tyhjennetty.");
    }
    public void kotiButton(ActionEvent event) {
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
    public void takaisinButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/majoitusvarausAloitusIkkuna.fxml"));
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
    void poistaVaraus(ActionEvent event) {
        Alert vahvistusHuomautus = new Alert(Alert.AlertType.CONFIRMATION);
        vahvistusHuomautus.setTitle("Vahvista varauksen poistaminen");
        vahvistusHuomautus.setHeaderText("Haluatko varmasti poistaa varauksen?");

        // painikkeet
        ButtonType kyllaBt = new ButtonType("KYLLÄ");
        ButtonType eiBt = new ButtonType("EN", ButtonBar.ButtonData.CANCEL_CLOSE);
        vahvistusHuomautus.getButtonTypes().setAll(kyllaBt, eiBt);

        Optional<ButtonType> result = vahvistusHuomautus.showAndWait();
        if (result.isPresent() && result.get() == kyllaBt) {
            System.out.println("Varaus poistettu!");
            // lisää poiston logiikka tietokantaan
        } else {
            System.out.println("Tapahtuma peruttu.");
        }
    }

    @FXML
    void tallennaMuutos(ActionEvent event) {
        try {
            int asiakasID = Integer.parseInt(asiakasField1.getText());
            int mokkiID = parseMokkiID(muokkaaChoice.getValue());
            LocalDate alku = alkupaivaDate1.getValue();
            LocalDate loppu = loppupaivaDate1.getValue();
            String lisatiedot = lisatietoField1.getText();

            // kenttien tarkastus
            if (mokkiID == -1 || alku == null || loppu == null) {
                syoteVaroitus("Tarkista kentät", "Jokin kenttä virheellinen");
                return;
            }
            // tietokantaan tallennus
            System.out.println("Tallennetaan muutos:");
            System.out.println("Asiakas ID: " + asiakasID);
            System.out.println("Mökki ID: " + mokkiID);
            System.out.println("Alku: " + alku);
            System.out.println("Loppu: " + loppu);
            System.out.println("Lisätiedot: " + lisatiedot);

            Alert tallennaVahvistus = new Alert(Alert.AlertType.INFORMATION);
            tallennaVahvistus.setTitle("Tallennus onnistui");
            tallennaVahvistus.setHeaderText(null);
            tallennaVahvistus.setContentText("Muutokset tallennettu onnistuneesti.");
            tallennaVahvistus.showAndWait();
        }catch (NumberFormatException e){
            syoteVaroitus("Virheellinen syöte", "Asiakas ID ei kelvollinen");
        }
    }
    private void syoteVaroitus(String otsikko, String viesti) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(otsikko);
        alert.setHeaderText(null);
        alert.setContentText(viesti);
        alert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // varaus choiceboxit
        muokkaaChoice.setValue("Mökki 1");
        muokkaaChoice.getItems().addAll(mokit);

        // asiakas textfieldit
        asiakasField1.setText("Etunimi Sukunimi");

        // kalenterien prompt-tekstit
        alkupaivaDate1.setPromptText("PV/KK/VUOSI");
        loppupaivaDate1.setPromptText("PV/KK/VUOSI");
    }
}
