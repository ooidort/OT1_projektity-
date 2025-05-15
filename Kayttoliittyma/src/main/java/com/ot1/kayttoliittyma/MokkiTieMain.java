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
        MokkiLuokka mokki1 = new MokkiLuokka(1,
                "Mökkitie 1",
                Timestamp.valueOf("1999-31-12 10:00:00"),
                Timestamp.valueOf("1999-31-12 10:00:00"),
                80,
                0);
                mokitdao.lisaaMokki(mokki1);

        MokkiLuokka mokki2 = new MokkiLuokka(2,
                "Mökkitie 2",
                Timestamp.valueOf("1999-31-12 10:00:00"),
                Timestamp.valueOf("1999-31-12 10:00:00"),
                120,
                0);
        mokitdao.lisaaMokki(mokki2);

        MokkiLuokka mokki3 = new MokkiLuokka(3,
                "Mökkitie 3",
                Timestamp.valueOf("1999-31-12 10:00:00"),
                Timestamp.valueOf("1999-31-12 10:00:00"),
                140,
                0);
        mokitdao.lisaaMokki(mokki3);

        MokkiLuokka mokki4 = new MokkiLuokka(4,
                "Mökkitie 4",
                Timestamp.valueOf("1999-31-12 10:00:00"),
                Timestamp.valueOf("1999-31-12 10:00:00"),
                1150,
                0);
        mokitdao.lisaaMokki(mokki4);

        //Mökin hakeminen
        MokkiLuokka haetttuMokki = mokitdao.getMokki(1);
        if (haetttuMokki != null) {
            System.out.println("Hait seuraavan mökin tiedot: " + " " + haetttuMokki.getMokkiID() +
                    haetttuMokki.getOsoite() + " " + haetttuMokki.getHinta());
        } else {
            System.out.println("Mökkiä ei löytynyt!");
        }
    }
}
