package com.example.majoitusvarauksetkayttoliittyma;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;


public class MajoitusvarauksetUI extends Application {
    @Override
    public void start(Stage stage) throws IOException{
        AnchorPane varausikkuna = new AnchorPane();

        TitledPane titledP = new TitledPane();
        titledP.setText("Majoitusvaraukset");


        // luodaan labelit, napit ja listview
        Label uusiVaraus = new Label("Uusi varaus");
        Label poistaJaMuokkaa = new Label("Muokkaa ja poista varauksia");
        Label mokkiLabel = new Label("Mökki:");
        Label asiakasLabel = new Label("Asiakas:");
        TextField asiakasField = new TextField("Asiakkaan nimi");
        Label alkuPaivaLabel = new Label("Alkupäivä:");
        TextField alkupaivaField = new TextField("Syötä päivämäärä");
        Label loppupaivaLabel = new Label("Loppupäivä:");
        TextField loppupaivaField = new TextField("Syötä päivämäärä");
        Label lisatiedotLabel = new Label("Lisätietoja:");
        TextField lisatiedotField = new TextField("Lisätietoja");
        Button tallennavarausBt = new Button("Tallenna varaus");
        Button peruutaBt = new Button("Peruuta");
        ListView<String> mokkiListaUusivaraus = new ListView<>();
        mokkiListaUusivaraus.getItems().addAll("Mökki 1", "Mökki 2","Mökki 3");
        mokkiListaUusivaraus.setPrefHeight(100);


        Label poistaJaMuokkaa1 = new Label("Muokkaa ja poista varauksia");
        Label mokkiLabel1 = new Label("Mökki:");
        Label asiakasLabel1 = new Label("Asiakas:");
        TextField asiakasField1 = new TextField("Asiakkaan nimi");
        Label alkuPaivaLabel1 = new Label("Alkupäivä:");
        TextField alkupaivaField1 = new TextField("Syötä päivämäärä");
        Label loppupaivaLabel1 = new Label("Loppupäivä:");
        TextField loppupaivaField1 = new TextField("Syötä päivämäärä");
        Label lisatiedotLabel1 = new Label("Lisätietoja:");
        TextField lisatiedotField1 = new TextField("Lisätietoja");
        Button tallennavarausBt1 = new Button("Tallenna varaus");
        Button peruutaBt1 = new Button("Peruuta");
        Button poistavarausBt1 = new Button("Poista varaus");
        ListView<String> mokkiListaMuokkaa = new ListView<>();
        mokkiListaMuokkaa.getItems().addAll("Mökki 1", "Mökki 2","Mökki 3");
        mokkiListaMuokkaa.setPrefHeight(100);

        // uusi varaus vbox
        VBox uusiVarausBox = new VBox();
        uusiVarausBox.setLayoutX(27);
        uusiVarausBox.setLayoutY(33);
        uusiVarausBox.setAlignment(Pos.TOP_LEFT);
        uusiVarausBox.setMinHeight(Region.USE_COMPUTED_SIZE);
        uusiVarausBox.setMinWidth(Region.USE_COMPUTED_SIZE);
        uusiVarausBox.setPrefWidth(154);
        uusiVarausBox.setPrefHeight(360);


        // poista ja muokkaa -vbox
        VBox poistaMuokkaaVbox = new VBox();
        poistaMuokkaaVbox.setLayoutX(380);
        poistaMuokkaaVbox.setLayoutY(33);
        poistaMuokkaaVbox.setAlignment(Pos.TOP_LEFT);
        poistaMuokkaaVbox.setMinHeight(Region.USE_COMPUTED_SIZE);
        poistaMuokkaaVbox.setMinWidth(Region.USE_COMPUTED_SIZE);
        poistaMuokkaaVbox.setPrefWidth(154);
        poistaMuokkaaVbox.setPrefHeight(360);

        // lisätään tiedot Vboxeihin
        uusiVarausBox.getChildren().addAll(uusiVaraus,mokkiLabel,mokkiListaUusivaraus,asiakasLabel,
                asiakasField,alkuPaivaLabel,alkupaivaField,
                loppupaivaLabel,loppupaivaField,
                lisatiedotLabel,lisatiedotField,tallennavarausBt,peruutaBt);

        poistaMuokkaaVbox.getChildren().addAll(poistaJaMuokkaa1,mokkiLabel1,mokkiListaMuokkaa,asiakasLabel1,asiakasField1,
                alkuPaivaLabel1,alkupaivaField1,
                loppupaivaLabel1,loppupaivaField1,
                lisatiedotLabel1,lisatiedotField1,tallennavarausBt1,peruutaBt1,poistavarausBt1);


        // Lisätään VBoxit anchorpaneen
        varausikkuna.getChildren().addAll(uusiVarausBox,poistaMuokkaaVbox);

        Scene scene = new Scene(varausikkuna);
        stage.setTitle("Majoitusvaraukset");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}