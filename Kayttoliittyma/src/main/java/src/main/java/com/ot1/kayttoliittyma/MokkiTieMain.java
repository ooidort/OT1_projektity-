package src.main.java.com.ot1.kayttoliittyma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
    }
}
