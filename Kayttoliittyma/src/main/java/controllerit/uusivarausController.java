package controllerit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class uusivarausController implements Initializable {
    @FXML
    private Label alkuPaivaLabel;

    @FXML
    private DatePicker alkupaivaDate;

    @FXML
    private TextField asiakasField;

    @FXML
    private Label asiakasLabel;

    @FXML
    private TextField lisatietoField;

    @FXML
    private Label lisatietoLabel;

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
    private ChoiceBox<String> uusivarausChoice;
    private String[] mokit = {"Mökki 1", "Mökki 2", "Mökki 3", "Mökki 4"};

    @FXML
    public void tyhjennakentat(){
        // tekstikenttien tyhjennys
        asiakasField.clear();
        lisatietoField.clear();

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
        if (result.isPresent() && result.get() == kyllaBt){
            System.out.println("Varaus on tallennettu!");
            // lisää poiston logiikka tietokantaan
        } else {
            System.out.println("Tapahtuma peruttu.");
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // varaus choicebox
        uusivarausChoice.setValue("Mökki 1");
        uusivarausChoice.getItems().addAll(mokit);

        // asiakas textfieldi
        asiakasField.setText("Etunimi Sukunimi");

        // kalenterien prompt-tekstit
        alkupaivaDate.setPromptText("PV/KK/VUOSI");
        loppupaivaDate.setPromptText("PV/KK/VUOSI");
    }
}
