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
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import tietokantahaut.HuoltoDAO;
import tietokantahaut.HuoltoLuokka;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HuoltotilaUIController {
    @FXML
    private Button kotiButtonM;
    @FXML
    private Button takaisinButtonM;
    @FXML
    private Button lisaaHuoltoButton;
    @FXML
    private ChoiceBox mokkiValinta;
    @FXML
    private DatePicker huoltoPaivamaaraDatePicker;
    @FXML
    private DatePicker huoltoErapaivaDatePicker;
    @FXML
    private TextArea huollonTiedot;

    private Map<String, MokkiLuokka> mokkiMap = new HashMap<>();

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


    public void huollonTiedot(javafx.event.ActionEvent actionEvent) {
        HuoltoDAO huoltodao = new HuoltoDAO();
    }

    public void tallennaHuolto(javafx.event.ActionEvent actionEvent) {
        try {
            String valittuOsoite = (String) mokkiValinta.getValue();

                    if (mokkiValinta != null && mokkiMap.containsKey(valittuOsoite)) {
                        System.out.println("Painoit tallenna nappia!");

                        MokkiLuokka valittuMokki = mokkiMap.get(valittuOsoite);
                        int mokkiID = valittuMokki.getMokkiID();

                        HuoltoDAO huoltodao = new HuoltoDAO();
                        HuoltoLuokka uusiHuolto = new HuoltoLuokka(0,
                                0,
                                "null",
                                "null",
                                Timestamp.valueOf("1999-12-31 10:00:00"),
                                Timestamp.valueOf("1999-12-31 10:00:00"));
                        uusiHuolto.setMokkiID(valittuMokki.getMokkiID());
                        uusiHuolto.setKohteet(huollonTiedot.getText());
                        uusiHuolto.setAlkupaiva(Timestamp.valueOf(huoltoPaivamaaraDatePicker.getValue().atStartOfDay()));
                        uusiHuolto.setLoppupaiva(Timestamp.valueOf(huoltoErapaivaDatePicker.getValue().atStartOfDay()));

                        int huoltoID = huoltodao.lisaaHuolto(uusiHuolto);
                        HuoltoLuokka tallennettu = huoltodao.getHuolto(huoltoID);
                        if (tallennettu != null) {
                            System.out.println("Tietokannasta haettu huolto: " + tallennettu.getKohteet());
                        } else {
                            System.out.println("Eeeeeepä löytynyt!");
                        }

                        System.out.println("Tallensit seuraavat tiedot: " + "HuoltoID: " + huoltoID
                        + ", MökkiID: " + mokkiID + ", Kohteet: " + uusiHuolto.getKohteet() +
                                ", Historia: " + uusiHuolto.getHistoria() + ", Alkupäivä: " +
                                uusiHuolto.getAlkupaiva() + ", Loppupäivä: " + uusiHuolto.getLoppupaiva());
                    } else {
                        System.out.println("Valitse mökki ennen tallennusta!");
                }
        } catch(Exception e) {
            e.printStackTrace();
        }
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
}
