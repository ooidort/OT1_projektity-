package com.ot1.kayttoliittyma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;
import tietokantahaut.TietokantaYhteys;

import java.sql.Timestamp;

public class MokkiTieMain extends Application {

    @Override
    public void start(Stage paaStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/AlkuNaytto.fxml"));
        paaStage.setTitle("Mökkitie");
        paaStage.setScene(new Scene(root));
        paaStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        MokitDAO mokitdao = new MokitDAO();

        //Mökin lisääminen
        MokkiLuokka mokit = new MokkiLuokka(111,
                "Mökkitie 666",
                Timestamp.valueOf("2025-05-12 10:00:00"),
                Timestamp.valueOf("2025-08-12 10:00:00"),
                127,
                1);
                mokitdao.lisaaMokki(mokit);

        //Mökin hakeminen
        MokkiLuokka haetttuMokki = mokitdao.getMokki(111);
        if (haetttuMokki != null) {
            System.out.println("Hait seuraavan mökin tiedot: " + " " + haetttuMokki.getMokkiID() +
                    haetttuMokki.getOsoite() + " " + haetttuMokki.getHinta());
        } else {
            System.out.println("Mökkiä ei löytynyt!");
        }
    }
}
