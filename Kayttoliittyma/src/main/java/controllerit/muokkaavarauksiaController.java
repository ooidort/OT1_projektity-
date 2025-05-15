package controllerit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
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
    private Label uusiVaraus1;

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
