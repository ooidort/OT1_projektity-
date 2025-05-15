package com.ot1.kayttoliittyma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class uusivarausUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage uusiVarausIkkuna) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/uusiVaraus.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        uusiVarausIkkuna.setTitle("Uusi varaus");
        uusiVarausIkkuna.setScene(scene);
        uusiVarausIkkuna.show();

    }
}
