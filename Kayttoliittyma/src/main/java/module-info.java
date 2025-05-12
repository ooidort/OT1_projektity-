module com.ot1.kayttoliittyma {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.ot1.kayttoliittyma to javafx.fxml;
    exports com.ot1.kayttoliittyma;
    exports src.main.java.com.ot1.kayttoliittyma;
    opens src.main.java.com.ot1.kayttoliittyma to javafx.fxml;
    exports tietokantahaut;
    opens tietokantahaut to javafx.fxml;
}