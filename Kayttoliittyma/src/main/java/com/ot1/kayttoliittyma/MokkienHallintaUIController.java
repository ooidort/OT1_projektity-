package com.ot1.kayttoliittyma;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MokkienHallintaUIController {


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

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
