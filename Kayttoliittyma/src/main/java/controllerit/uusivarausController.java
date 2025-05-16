package controllerit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import tietokantahaut.MajoitusvarausLuokka;
import tietokantahaut.VarausDAO;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class uusivarausController implements Initializable {
    @FXML
    private Label alkuPaivaLabel;

    @FXML
    private DatePicker alkupaivaDate;

    @FXML
    private ChoiceBox<String> asiakasChoiceBox;
    private String[] asiakkaat = {"Asiakas 1", "Asiakas 2", "Asiakas 3", "Asiakas 4"};


    @FXML
    private Label asiakasLabel;

    @FXML
    private Label loppuPaivaLabel;

    @FXML
    private DatePicker loppupaivaDate;

    @FXML
    private Button peruutaBt;

    @FXML
    private Label mokkiLabel;

    @FXML
    private Button tallennavarausBt;

    @FXML
    private Label uusiVaraus;

    @FXML
    private VBox uusiVarausBox;

    @FXML
    private Button kotiButton;

    @FXML
    private Button takaisinButton;

    @FXML
    private ChoiceBox<String> uusivarausChoice;
    private String[] mokit = {"Mökki 1", "Mökki 2", "Mökki 3", "Mökki 4"};

    @FXML
    public void tyhjennakentat(){
        asiakasChoiceBox.setValue(null);
        // choicebox palautus oletusarvoon
        uusivarausChoice.setValue(null);

        // DatePickerit
        alkupaivaDate.setValue(null);
        loppupaivaDate.setValue(null);
    }


    @FXML
    void peruutaMuutokset(ActionEvent event) {
        tyhjennakentat();
        System.out.println("Kentät tyhjennetty.");

    }
    public void kotiButton(ActionEvent event){
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
    void tallennaVaraus(ActionEvent event) {
        Alert tallennaVaraus = new Alert(Alert.AlertType.CONFIRMATION);
        tallennaVaraus.setTitle("Vahvista varaus");
        tallennaVaraus.setHeaderText("Haluatko varmasti tallentaa varauksen?");

        // painikkeet
        ButtonType kyllaBt = new ButtonType("KYLLÄ");
        ButtonType eiBt = new ButtonType("EN",ButtonBar.ButtonData.CANCEL_CLOSE);
        tallennaVaraus.getButtonTypes().setAll(kyllaBt, eiBt);

        Optional<ButtonType> result = tallennaVaraus.showAndWait();
        if (result.isPresent() && result.get() == kyllaBt) { // jos käyttäjä valitsee Kyllä
            try {
                String asiakasString = asiakasChoiceBox.getValue();
                int asiakasID = haeAsiakasID(asiakasString);
                String mokkiNimi = uusivarausChoice.getValue();
                int mokkiID = haeMokkiID(mokkiNimi); // tee tälle metodi!!
                LocalDateTime alkupv = alkupaivaDate.getValue().atStartOfDay();
                LocalDateTime loppupv = loppupaivaDate.getValue().atStartOfDay();


                // luodaan varausolio
                MajoitusvarausLuokka varaus = new MajoitusvarausLuokka(mokkiID, asiakasID, alkupv, loppupv,0);

                // tallennus tietokantaan
                VarausDAO tallennus = new VarausDAO();
                tallennus.lisaaVaraus(varaus);

            } catch (SQLException e) { // virheen sattuessa ilmoitus, mikäli varauksen tallennus ei onnistunut
                e.printStackTrace();
                Alert virhetallennuksessa = new Alert(Alert.AlertType.ERROR, "Varauksen tallennus epäonnistui:"
                + e.getMessage());
                virhetallennuksessa.showAndWait();
            }
        } else {
            System.out.println("Tapahtuma peruutettu.");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // varaus choicebox
        uusivarausChoice.setValue("Mökki 1");
        uusivarausChoice.getItems().addAll(mokit);

        // asiakas textfieldi
        asiakasChoiceBox.setValue("Asiakas 1");
        asiakasChoiceBox.getItems().addAll(asiakkaat);

        // kalenterien prompt-tekstit
        alkupaivaDate.setPromptText("PV/KK/VUOSI");
        loppupaivaDate.setPromptText("PV/KK/VUOSI");
    }
    // metodi, joka muuttaa mökin nimen numeroksi (ID)
    private int haeMokkiID(String mokkiNimi) {
        switch (mokkiNimi) {
            case "Mökki 1": return 1;
            case "Mökki 2": return 2;
            case "Mökki 3": return 3;
            case "Mökki 4": return 4;
                default: return 0;
        }
    }
    private int haeAsiakasID(String asiakasString) {
        try {
            return Integer.parseInt(asiakasString.replaceAll("\\D+", ""));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
