module com.example.canteensystem2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;




    opens com.example.canteensystem2 to javafx.fxml;
    exports com.example.canteensystem2;
    exports Model.DaoObjects;
    opens Model.DaoObjects to javafx.fxml;
    exports View;
    opens View to javafx.fxml;
}