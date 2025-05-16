package controllerit;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tietokantahaut.HuoltoDAO;
import tietokantahaut.HuoltoLuokka;
import tietokantahaut.MokitDAO;
import tietokantahaut.MokkiLuokka;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class HuoltojenPoistoUIController {
    @FXML
    private Button kotiButtonM;
    @FXML
    private Button takaisinButtonM;
    @FXML
    private Button poistaH;
    @FXML
    private ListView huoltoLista;

    private Map<String, MokkiLuokka> mokkiMap = new HashMap<>();
    private Map<String, HuoltoLuokka> huoltoMap = new HashMap<>();



    //Toiminto koti-buttonille
            public void kotiButton (javafx.event.ActionEvent actionEvent){
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


            //Toiminto takaisin-buttonille
            public void takaisinButton (javafx.event.ActionEvent actionEvent){

                try {
                    FXMLLoader fxmlLoader = new
                            FXMLLoader(getClass().getResource("/ui/MokkienHallintaUI.fxml"));
                    Parent root = fxmlLoader.load();


                    Stage uusiIkkuna = new Stage();
                    Scene takaisinScene = new Scene(root);
                    uusiIkkuna.setScene(takaisinScene);
                    uusiIkkuna.setTitle("Mökkien hallinta");
                    uusiIkkuna.show();

                    Stage stage = (Stage) takaisinButtonM.getScene().getWindow();
                    stage.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



