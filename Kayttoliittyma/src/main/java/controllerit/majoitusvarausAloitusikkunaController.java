package controllerit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class majoitusvarausAloitusikkunaController {
    @FXML
    private Button poistajamuokkaaBt;

    @FXML
    private Button uusivarausBt;

    @FXML
    public void uusiVarausButton(ActionEvent event) {
        try {
            // lataa uuden näkymän
            System.out.println("Klikkasit Uusi varaus -painiketta!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/uusiVaraus.fxml"));
            Parent root = fxmlLoader.load();

            Stage uusivarausIkkuna = new Stage();
            Scene mokkienhallintaScene = new Scene(root);
            uusivarausIkkuna.setScene(mokkienhallintaScene);
            uusivarausIkkuna.setTitle("Mökkien hallinta");
            uusivarausIkkuna.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void muokkaaVarauksiaButton(ActionEvent event){
        try{
            System.out.println("Klikkasit Poista ja muokkaa varauksia -painiketta!");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/muokkaaVarauksia.fxml"));
            Parent root = fxmlLoader.load();

            Stage poistajamuokkaaIkkuna = new Stage();
            Scene mokkienhallintaScene = new Scene(root);
            poistajamuokkaaIkkuna.setScene(mokkienhallintaScene);
            poistajamuokkaaIkkuna.setTitle("Mökkien hallinta");
            poistajamuokkaaIkkuna.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
