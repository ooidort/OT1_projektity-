package controllerit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MokkienHallintaUIController {
    @FXML
    private Button kotiButtonM;

    @FXML
    private void initialize() {
        ObservableList<String> mokkiLista = FXCollections.observableArrayList("Mökki1", "Mökki 2", "Mökki 3");
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
