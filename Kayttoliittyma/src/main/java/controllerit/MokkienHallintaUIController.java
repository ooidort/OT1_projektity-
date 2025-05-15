package controllerit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import org.w3c.dom.Text;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MokkienHallintaUIController {

    @FXML
    private Button kotiButtonM;

    @FXML
    private TextArea shuollot;

    @FXML
    private TextArea khuollot;

    @FXML
    private TextArea ahuollot;

    @FXML
    private TextArea kapasiteetti;

    @FXML
    private TextArea huoneet;

    @FXML
    private TextArea kaytettavyys;

    @FXML
    private TextArea muut;

    @FXML
    private ListView mokkiListView;

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
            mokkiListView.setItems(mokkiLista);

            mokkiListView.getSelectionModel().selectedItemProperty().addListener((observable, vanhaValinta, uusiValinta) -> {
                if (uusiValinta != null) {
                    MokkiLuokka valittuMokki = mokkiMap.get(uusiValinta);
                    if (valittuMokki != null) {
                        huoneet.setText("Mökissä on " + String.valueOf(valittuMokki.getHuoneet()) + " huonetta.");
                        kapasiteetti.setText("Mökkiin mahtuu " + String.valueOf(valittuMokki.getKapasiteetti()) + " henkilöä");
                        muut.setText("Ei muita tietoja");
                        kaytettavyys.setText("Mökki on varattu aikavälille " +
                                String.valueOf(valittuMokki.getVarauksenAlku()) + " - " + String.valueOf(valittuMokki.getVarauksenLoppu()));
                    }
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
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

    public void naytaVaraustiedot(javafx.event.ActionEvent actionEvent) {
        try {
            System.out.println("Klikkasit varaustietonäppäintä!");
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/KaytettavyysUI.fxml"));
            Parent root = fxmlLoader.load();

            Stage uusiIkkuna = new Stage();
            Scene varaustiedotScene = new Scene(root);
            uusiIkkuna.setScene(varaustiedotScene);
            uusiIkkuna.setTitle("Varaustiedot");
            uusiIkkuna.show();

            Stage stage = (Stage) kotiButtonM.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lisaaHuolto(ActionEvent actionEvent) {
        try {
            System.out.println("Klikkasit huoltojen lisäysnäppäintä!!");
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/HuoltotilaUI.fxml"));
            Parent root = fxmlLoader.load();

            Stage uusiIkkuna = new Stage();
            Scene varaustiedotScene = new Scene(root);
            uusiIkkuna.setScene(varaustiedotScene);
            uusiIkkuna.setTitle("Huoltotila");
            uusiIkkuna.show();

            Stage stage = (Stage) kotiButtonM.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void poistaHuolto(ActionEvent actionEvent) {
        try {
            System.out.println("Klikkasit huoltojen poistonäppäintä!!");
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/HuoltojenpoistoUI.fxml"));
            Parent root = fxmlLoader.load();

            Stage uusiIkkuna = new Stage();
            Scene varaustiedotScene = new Scene(root);
            uusiIkkuna.setScene(varaustiedotScene);
            uusiIkkuna.setTitle("Poista huolto");
            uusiIkkuna.show();

            Stage stage = (Stage) kotiButtonM.getScene().getWindow();
            stage.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
