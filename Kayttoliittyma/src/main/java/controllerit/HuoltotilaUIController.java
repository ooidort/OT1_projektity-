package controllerit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import tietokantahaut.HuoltoDAO;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HuoltotilaUIController {
    @FXML
    private Button kotiButtonM;
    @FXML
    private Button takaisinButtonM;
    @FXML
    private Button lisaaHuolto;
    @FXML
    private ChoiceBox mokkiValinta;
    @FXML
    private DatePicker huoltoPaivamaaraDatePicker;
    @FXML
    private DatePicker huoltoErapaivaDatePicker;
    @FXML

    private Map<String, MokkiLuokka> mokkiMap = new HashMap<>();

    @FXML
    private void initialize() {
        try {
            MokitDAO mokitdao = new MokitDAO();
            ObservableList<String> mokkiLista = FXCollections.observableArrayList();

            for (int i = 1; i <= 4; i++) {
                MokkiLuokka haettuMokki = mokitdao.getMokki(i);
                if (haettuMokki != null) {
                    mokkiLista.add(haettuMokki.getOsoite());
                    mokkiMap.put(haettuMokki.getOsoite(), haettuMokki);
                    System.out.println(haettuMokki.getOsoite());
                } else {
                    System.out.println("Mökkejä ei löytynyt!");
                }
            }
            mokkiValinta.setItems(mokkiLista);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void lisaaHuolto(javafx.event.ActionEvent actionEvent) {
        HuoltoDAO huoltodao = new HuoltoDAO();

    }

    //Toiminto koti-buttonille
    public void kotiButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/AlkuNaytto.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene kotiButtonScene = new Scene(root);
            uusiIkkuna.setScene(kotiButtonScene);
            uusiIkkuna.setTitle("Mökkitie");
            uusiIkkuna.show();

            Stage stage = (Stage) kotiButtonM.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Toiminto takaisin-buttonille
    public void takaisinButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/MokkienHallintaUI.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene takaisinScene = new Scene(root);
            uusiIkkuna.setScene(takaisinScene);
            uusiIkkuna.setTitle("Mökkien hallinta");
            uusiIkkuna.show();

            Stage stage = (Stage) takaisinButtonM.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Päivämäärä datepicker toimimaan
    @FXML
    private void handleAloitusPaiva() {
        LocalDate aloitusPaiva = huoltoPaivamaaraDatePicker.getValue();
        System.out.println("Aloituspäivä: " + aloitusPaiva);
    }

    //Eräpäivä datepicker toimimaan
    @FXML
    private void handleEraPaiva() {
        LocalDate eraPaiva = huoltoErapaivaDatePicker.getValue();
        System.out.println("Eräpäivä: " + eraPaiva);
    }
}
