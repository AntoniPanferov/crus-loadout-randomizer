module com.crusloadoutrandomizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.crusloadoutrandomizer to javafx.fxml;
    exports com.crusloadoutrandomizer;
}