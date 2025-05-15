package com.ot1.kayttoliittyma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class muokkaavarauksiaUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage varausmuokkausIkkuna) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/muokkaaVarauksia.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        varausmuokkausIkkuna.setTitle("Poista ja muokkaa varauksia");
        varausmuokkausIkkuna.setScene(scene);
        varausmuokkausIkkuna.show();

    }
}
