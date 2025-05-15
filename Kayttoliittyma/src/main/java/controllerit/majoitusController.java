package controllerit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class majoitusController implements Initializable {

    @FXML
    private ChoiceBox<String> uusivarausChoice;

    @FXML
    private ChoiceBox<String> muokkaaChoice;

    private String[] mokit = {"Mökki 1", "Mökki 2", "Mökki 3"};

    @FXML
    private Label alkuPaivaLabel;

    @FXML
    private Label alkuPaivaLabel1;

    @FXML
    private DatePicker alkupaivaDate;

    @FXML
    private DatePicker alkupaivaDate1;

    @FXML
    private TextField asiakasField;

    @FXML
    private TextField asiakasField1;

    @FXML
    private Label asiakasLabel;

    @FXML
    private Label asiakasLabel1;

    @FXML
    private TextField lisatietoField;

    @FXML
    private TextField lisatietoField1;

    @FXML
    private Label lisatietoLabel;

    @FXML
    private Label lisatietoLabel1;

    @FXML
    private Label loppuPaivaLabel;

    @FXML
    private Label loppuPaivaLabel1;

    @FXML
    private DatePicker loppupaivaDate;

    @FXML
    private DatePicker loppupaivaDate1;

    @FXML
    private Label mokkiLabel1;

    @FXML
    private Button peruutaBt;

    @FXML
    private Button peruutaBt1;

    @FXML
    private Label poistaJaMuokkaa;

    @FXML
    private VBox poistaMuokkaavarauksia;

    @FXML
    private Button poistavarausBt;

    @FXML
    private Button tallennavarausBt;

    @FXML
    private Button tallennavarausBt1;

    @FXML
    private Label uusiVaraus;

    @FXML
    private Label uusiVaraus1;

    @FXML
    private VBox uusiVarausBox;


    @FXML
    public void tyhjennakentat() {
        // tekstikenttien tyhjennys
        asiakasField.clear();
        asiakasField1.clear();
        lisatietoField.clear();
        lisatietoField1.clear();

        // choicebox palautus oletusarvoon
        uusivarausChoice.setValue(null);
        muokkaaChoice.setValue(null);

        // DatePickerit
        alkupaivaDate.setValue(null);
        alkupaivaDate1.setValue(null);
        loppupaivaDate.setValue(null);
        loppupaivaDate1.setValue(null);
    }

    // peruuta -painikkeen toiminta
    @FXML
    void peruutaMuutokset(ActionEvent event) {
        tyhjennakentat();
        System.out.println("Kentät tyhjennetty.");

    }

    // varauksen poistaminen
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

    // muutosten tallennus
    @FXML
    void tallennaMuutos(ActionEvent event) {
        Alert tallennaVahvistus = new Alert(Alert.AlertType.CONFIRMATION);
        tallennaVahvistus.setTitle("Vahvista muutoksen tallennus");
        tallennaVahvistus.setHeaderText("Haluatko varmasti tallentaa muutokset?");

        // painikkeet
        ButtonType kyllaBt = new ButtonType("KYLLÄ");
        ButtonType eiBt = new ButtonType("EN", ButtonBar.ButtonData.CANCEL_CLOSE);
        tallennaVahvistus.getButtonTypes().setAll(kyllaBt, eiBt);

        Optional<ButtonType> result = tallennaVahvistus.showAndWait();
        if (result.isPresent() && result.get() == kyllaBt) {
            System.out.println("Muutokset tallennettu!");
            // lisää poiston logiikka tietokantaan
        } else {
            System.out.println("Tapahtuma peruttu.");
        }
    }

    @FXML
    void tallennaVaraus(ActionEvent event) {
        Alert tallennaVaraus = new Alert(Alert.AlertType.CONFIRMATION);
        tallennaVaraus.setTitle("Vahvista varaus");
        tallennaVaraus.setHeaderText("Haluatko varmasti tallentaa varauksen?");

        // painikkeet
        ButtonType kyllaBt = new ButtonType("KYLLÄ");
        ButtonType eiBt = new ButtonType("EN", ButtonBar.ButtonData.CANCEL_CLOSE);
        tallennaVaraus.getButtonTypes().setAll(kyllaBt, eiBt);

        Optional<ButtonType> result = tallennaVaraus.showAndWait();
        if (result.isPresent() && result.get() == kyllaBt) {
            System.out.println("Varaus on tallennettu!");
            // lisää poiston logiikka tietokantaan
        } else {
            System.out.println("Tapahtuma peruttu.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // varaus choiceboxit
        uusivarausChoice.setValue("Mökki 1");
        uusivarausChoice.getItems().addAll(mokit);
        muokkaaChoice.setValue("Mökki 1");
        muokkaaChoice.getItems().addAll(mokit);

        // asiakas textfieldit
        asiakasField.setText("Etunimi Sukunimi");
        asiakasField1.setText("Etunimi Sukunimi");

        // kalenterien prompt-tekstit
        alkupaivaDate.setPromptText("PV/KK/VUOSI");
        alkupaivaDate1.setPromptText("PV/KK/VUOSI");
        loppupaivaDate.setPromptText("PV/KK/VUOSI");
        loppupaivaDate1.setPromptText("PV/KK/VUOSI");
    }
}
