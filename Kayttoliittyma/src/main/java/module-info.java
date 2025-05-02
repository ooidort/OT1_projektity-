module com.ot1.kayttoliittyma {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.ot1.kayttoliittyma to javafx.fxml;
    exports com.ot1.kayttoliittyma;
}