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
import tietokantahaut.MajoitusvarausLuokka;
import tietokantahaut.VarausDAO;

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
    private ChoiceBox<String> asiakasChoiceBox1;
    private String[] asiakkaat = {"Asiakas 1", "Asiakas 2", "Asiakas 3", "Asiakas 4"};

    @FXML
    private Label asiakasLabel1;

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

    private int haettuVarausID = -1;

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
        System.out.println("Tyhjensit kentät");
        // tekstikenttien tyhjennys
        asiakasChoiceBox1.setValue(null);

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
            try {
                int varausID = haettuVarausID; // Tee tämä metodi!!
                VarausDAO poisto = new VarausDAO();
                poisto.poistaVaraus(varausID);

                Alert ilmoitus = new Alert(Alert.AlertType.INFORMATION); // ilmoitus poistetusta varauksesta
                ilmoitus.setTitle("Varaus poistettu");
                ilmoitus.setHeaderText(null);
                ilmoitus.setContentText("Varauksen poistaminen onnistui!");
                ilmoitus.showAndWait();

                tyhjennaKentat();
            } catch (Exception e) {
                e.printStackTrace();
                syoteVaroitus("Virhe", "Virhe varauksen poistamisessa");
            }
        }
    }

    @FXML
    void tallennaMuutos(ActionEvent event) {
        try {
            String asiakasString = asiakasChoiceBox1.getValue();
            int asiakasID = parseAsiakasID(asiakasString);
            int mokkiID = parseMokkiID(muokkaaChoice.getValue());
            LocalDate alku = alkupaivaDate1.getValue();
            LocalDate loppu = loppupaivaDate1.getValue();

            // tarkastaa kentät
            if (asiakasID == -1 || mokkiID == -1 || alku == null || loppu == null) {
                syoteVaroitus("Tarkista kentät", "Jokin kenttä virheellinen");
                return;
            }

            // tietokantaan tallennus
            System.out.println("Tallennetaan muutos:");
            System.out.println("Asiakas ID: " + asiakasID);
            System.out.println("Mökki ID: " + mokkiID);
            System.out.println("Alku: " + alku);
            System.out.println("Loppu: " + loppu);

            Alert tallennaVahvistus = new Alert(Alert.AlertType.INFORMATION);
            tallennaVahvistus.setTitle("Tallennus onnistui");
            tallennaVahvistus.setHeaderText(null);
            tallennaVahvistus.setContentText("Muutokset tallennettu onnistuneesti.");
            tallennaVahvistus.showAndWait();
        } catch (NumberFormatException e) {
            syoteVaroitus("Virheellinen syöte", "asiakasID tai mokkiID virheellinen");
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
        asiakasChoiceBox1.setValue("Asiakas 1");
        asiakasChoiceBox1.getItems().addAll(asiakkaat);

        // kalenterien prompt-tekstit
        alkupaivaDate1.setPromptText("PV/KK/VUOSI");
        loppupaivaDate1.setPromptText("PV/KK/VUOSI");
    }

    // Luodaan haettuvarausID -metodi
    private void asetaValittuVaraus(MajoitusvarausLuokka varaus) {
        haettuVarausID = varaus.getVarausID();
        asiakasChoiceBox1.setValue("Asiakas: " + varaus.getAsiakasID());
        muokkaaChoice.setValue("Mökki " + varaus.getMokkiID());
        alkupaivaDate1.setValue(varaus.getVarauksenAlku().toLocalDate());
        loppupaivaDate1.setValue(varaus.getVarauksenLoppu().toLocalDate());
    }
    // metodi, joka luo asiakasID:n merkkijonosta
    private int parseAsiakasID(String asiakasString) {
        try {
            return Integer.parseInt(asiakasString.replaceAll("\\D+", ""));
        } catch (NumberFormatException e) {
            return -1; // Virheellinen syöte
        }
    }
}
