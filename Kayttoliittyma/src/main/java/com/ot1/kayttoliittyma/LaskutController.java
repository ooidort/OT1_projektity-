package src.main.java.com.ot1.kayttoliittyma;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ChoiceBox;
import java.time.LocalDate;

public class LaskutController {
    ObservableList<String> asiakasLista = FXCollections.observableArrayList("Asiakas 1", "Asiakas 2", "Asiakas 3");
    ObservableList<String> mokkiLista = FXCollections.observableArrayList("Mökki1", "Mökki 2", "Mökki 3");
    ObservableList<String> paivatLista = FXCollections.observableArrayList("1", "2", "3");
    ObservableList<String> loppusiivousLista = FXCollections.observableArrayList("0", "1", "2");

    @FXML
    private DatePicker laskuPaivamaaraDatePicker;
    @FXML
    private DatePicker laskuErapaivaDatePicker;
    @FXML
    private ChoiceBox asiakasChoiceBox;
    @FXML
    private ChoiceBox mokkiChoiceBox;
    @FXML
    private ChoiceBox paivatChoiceBox;
    @FXML
    private ChoiceBox loppusiivousChoiceBox;

    @FXML
    private void initialize() {
        asiakasChoiceBox.setValue("Asiakas 1");
        asiakasChoiceBox.setItems(asiakasLista);

        mokkiChoiceBox.setValue("Mökki 1");
        mokkiChoiceBox.setItems(mokkiLista);

        paivatChoiceBox.setValue("1");
        paivatChoiceBox.setItems(paivatLista);

        loppusiivousChoiceBox.setValue("0");
        paivatChoiceBox.setItems(loppusiivousLista);
    }


    public void valitseLaskunPaivamaara () {
        LocalDate valittuPaivamaara = laskuPaivamaaraDatePicker.getValue();
    }

    public void valitseErapaiva () {
        LocalDate valittuErapaiva = laskuErapaivaDatePicker.getValue();
    }

    public void valitseAsiakas () {
    }
    public void valitseMokki () {
    }
    public void valitsePaivat () {
    }
    public void valitseSiivous () {
    }

}
