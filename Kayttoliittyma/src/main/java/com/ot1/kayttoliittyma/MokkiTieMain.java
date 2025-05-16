package com.ot1.kayttoliittyma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tietokantahaut.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

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

        /*
        MokitDAO mokitdao = new MokitDAO();

        //Mökin lisääminen
        MokkiLuokka mokki1 = new MokkiLuokka(1,
                "Mökkitie 1",
                Timestamp.valueOf("1999-12-31 10:00:00"),
                Timestamp.valueOf("1999-12-31 10:00:00"),
                80,
                0, 3, 6);
        mokitdao.lisaaMokki(mokki1);

        MokkiLuokka mokki2 = new MokkiLuokka(2,
                "Mökkitie 2",
                Timestamp.valueOf("1999-12-31 10:00:00"),
                Timestamp.valueOf("1999-12-31 10:00:00"),
                120,
                0, 4, 8);
        mokitdao.lisaaMokki(mokki2);

        MokkiLuokka mokki3 = new MokkiLuokka(3,
                "Mökkitie 3",
                Timestamp.valueOf("1999-12-31 10:00:00"),
                Timestamp.valueOf("1999-12-31 10:00:00"),
                140,
                0, 5, 12);
        mokitdao.lisaaMokki(mokki3);

        MokkiLuokka mokki4 = new MokkiLuokka(4,
                "Mökkitie 4",
                Timestamp.valueOf("1999-12-31 10:00:00"),
                Timestamp.valueOf("1999-12-31 10:00:00"),
                150,
                0, 7, 16);
        mokitdao.lisaaMokki(mokki4);


        VarausDAO vdao = new VarausDAO();
        // testi varauksille
        MajoitusvarausLuokka varaustesti = new MajoitusvarausLuokka(
                2, 1,
                LocalDateTime.of(2025, 3, 1, 0, 0),
                LocalDateTime.of(2025, 3, 5, 0, 0),
                0
        );
        try{
            vdao.lisaaVaraus(varaustesti);
            System.out.println("Varauksen lisääminen onnistui.");

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Varauksen lisäämisessä tapahtui virhe.");
        }
*/    }
}
