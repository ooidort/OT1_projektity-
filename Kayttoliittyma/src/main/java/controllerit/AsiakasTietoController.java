package controllerit;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AsiakasTietoController {

    @FXML private TextField nimiField;
    @FXML private TextField osoiteField;
    @FXML private TextField puhelinField;
    @FXML private TextField sahkopostiField;
    @FXML private Button tallennaButton;
    @FXML private Button peruutaButton;

    @FXML
    private void initialize() {
        // Alustustoimintoja voi kirjoittaa tänne
    }

    @FXML
    private void handleTallenna() {
        String nimi = nimiField.getText();
        String osoite = osoiteField.getText();
        String puhelin = puhelinField.getText();
        String sahkoposti = sahkopostiField.getText();

        System.out.println("Tallennetaan asiakas:");
        System.out.println("Nimi: " + nimi);
        System.out.println("Osoite: " + osoite);
        System.out.println("Puhelin: " + puhelin);
        System.out.println("Sähköposti: " + sahkoposti);

        // Tallennuslogiikka tähän
    }

    @FXML
    private void handlePeruuta() {
        nimiField.clear();
        osoiteField.clear();
        puhelinField.clear();
        sahkopostiField.clear();
    }
}