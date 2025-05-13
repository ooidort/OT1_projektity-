package com.ot1.kayttoliittyma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MajoitusVarausUI extends Application {
    @Override
    public void start(Stage majoitusvarausIkkuna) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/MajoitusVarausUI.fxml"));
        majoitusvarausIkkuna.setTitle("Majoitusvarausikkuna");
        Scene scene = new Scene(fxmlLoader.load());
        majoitusvarausIkkuna.setScene(scene);
        majoitusvarausIkkuna.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
