module com.example.canteensystem2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.canteensystem2 to javafx.fxml;
    exports com.example.canteensystem2;
}