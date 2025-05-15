package controllerit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;

import java.io.IOException;

public class AlkuNayttoUIController {
    @FXML
    private Button laskutButton;
    @FXML
    private Button mokitButton;
    @FXML
    private Button asiakasButton;
    @FXML
    private Button varauksetButton;

    public void mokkienhallintaButton(javafx.event.ActionEvent actionEvent) {

        try {
            MokitDAO mokitdao = new MokitDAO();

            for (int i = 1; i <= 4; i++) {
                MokkiLuokka haettuMokki = mokitdao.getMokki(i);
                if (haettuMokki != null) {
                    System.out.println("Hait seuraavan mökin tiedot: " +
                            haettuMokki.getMokkiID() + " " + haettuMokki.getOsoite() +
                            " " + haettuMokki.getHinta());
                } else {
                    System.out.println("Mökkejä ei löytynyt!");
                }
            }

            System.out.println("Klikkasit mökkienhallintanäppäintä!");
            FXMLLoader fxmlLoader = new
            FXMLLoader(getClass().getResource("/ui/MokkienHallintaUI.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene mokkienhallintaScene = new Scene(root);
            uusiIkkuna.setScene(mokkienhallintaScene);
            uusiIkkuna.setTitle("Mökkien hallinta");
            uusiIkkuna.show();

            Stage stage = (Stage) mokitButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void majoitusvarauksetButton(ActionEvent actionEvent) {
        try{
            System.out.println("Klikkasit majoitusvarausnäppäintä!");
            FXMLLoader fxmlLoader = new FXMLLoader
                    (getClass().getResource("/ui/majoitusvarausAloitusIkkuna.fxml"));
            Parent root = fxmlLoader.load();
            Stage varausIkkuna = new Stage();
            Scene majoitusVarauksetScene = new Scene(root);
            varausIkkuna.setTitle("Majoitusvaraukset");
            varausIkkuna.setScene(majoitusVarauksetScene);
            varausIkkuna.show();

            Stage stage = (Stage) varauksetButton.getScene().getWindow();
            stage.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void asiakashallintaButton(ActionEvent actionEvent) {
        System.out.println("Klikkasit asiakashallintanäppäintä!");
    }

    public void laskutmetodiButton(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader = new
                    FXMLLoader(getClass().getResource("/ui/laskut.fxml"));
            Parent root = fxmlLoader.load();


            Stage uusiIkkuna = new Stage();
            Scene laskutScene = new Scene(root);
            uusiIkkuna.setScene(laskutScene);
            uusiIkkuna.setTitle("Laskujen hallinta");
            uusiIkkuna.show();

            Stage stage = (Stage) laskutButton.getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
