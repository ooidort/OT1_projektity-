package controllerit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import tietokantahaut.LaskuDAO;
import tietokantahaut.LaskuLuokka;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;

import java.io.IOException;

public class LaskutController {

    @FXML
    private Button takaisinButton;
    @FXML
    private Button kotiButton;
    @FXML
    private Button uusiLaskuButton;
    @FXML
    private Button muokkaaLaskujaButton;
    @FXML
    private TextArea mennytlasku1;
    @FXML
    private TextArea mennytlasku2;
    @FXML
    private TextArea mennytlasku3;
    @FXML
    private TextArea mennytlasku4;
    @FXML
    private TextArea mennytlasku5;
    @FXML
    private TextArea tulevaLasku1;
    @FXML
    private TextArea tulevaLasku2;
    @FXML
    private TextArea tulevaLasku3;
    @FXML
    private TextArea tulevaLasku4;
    @FXML
    private TextArea tulevaLasku5;


    public void uusiLaskuButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/UusiLasku.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene uusiLaskuScene = new Scene(root);
            uusiIkkuna.setScene(uusiLaskuScene);
            uusiIkkuna.setTitle("Uusi lasku");
            uusiIkkuna.show();

            Stage stage = (Stage) uusiLaskuButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void muokkaaLaskujaButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/MuokkaaJaPoistaLaskuja.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene muokkaaLaskujaScene = new Scene(root);
            uusiIkkuna.setScene(muokkaaLaskujaScene);
            uusiIkkuna.setTitle("Muokkaa ja poista laskuja");
            uusiIkkuna.show();

            Stage stage = (Stage) takaisinButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

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

            Stage stage = (Stage) kotiButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void takaisinButton(javafx.event.ActionEvent actionEvent) {

        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/Alkunaytto.fxml"));
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

}
