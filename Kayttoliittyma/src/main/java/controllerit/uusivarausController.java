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
    private Button kotiButton;

    @FXML
    private Button takaisinButton;

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
