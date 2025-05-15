package com.ot1.kayttoliittyma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MajoitusVarausController implements Initializable {

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
    private Label mokkiLabel11;

    @FXML
    private Button peruutaBt;

    @FXML
    private Button peruutaBt1;

    @FXML
    private Label poistaJaMuokkaa;

    @FXML
    private Label poistaJaMuokkaa1;

    @FXML
    private VBox poistaMuokkaavarauksia;

    @FXML
    private VBox poistaMuokkaavarauksia1;

    @FXML
    private Button poistavarausBt;

    @FXML
    private Button poistavarausBt1;

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
    private VBox uusiVarausBox1;


    @FXML
    void peruutaMuutokset(ActionEvent event) {
        System.out.println("Muutokset peruutettu!");

    }

    @FXML
    void peruutaVaraus(ActionEvent event) {
        System.out.println("Varaus peruutettu!");

    }

    @FXML
    void poistaVaraus(ActionEvent event) {
        System.out.println("Varaus poistettu!");

    }

    @FXML
    void tallennaMuutos(ActionEvent event) {
        System.out.println("Muutokset tallennettu!");
    }

    @FXML
    void tallennaVaraus(ActionEvent event) {
        System.out.println("Varaus tallennettu!");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        uusivarausChoice.getItems().addAll(mokit);
        uusivarausChoice.setValue("Mökki 1");
        muokkaaChoice.getItems().addAll(mokit);
        muokkaaChoice.setValue("Mökki 1");
    }
    // uusi varaus ChoiceBox
    public void getMokit(ActionEvent event) {
        String sMokit = uusivarausChoice.getValue();

    }
    // poista ja muokkaa ChoiceBox
    public void getMokit2(ActionEvent event) {
        String sMokit = muokkaaChoice.getValue();
    }
}


