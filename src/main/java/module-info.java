module com.example.martialschool {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.martialschool to javafx.fxml;
    exports com.example.martialschool;
    exports com.example.martialschool.additionalMethods;
    opens com.example.martialschool.additionalMethods to javafx.fxml;
    exports com.example.martialschool.enity;
    opens com.example.martialschool.enity to javafx.fxml;
    exports com.example.martialschool.server;
    opens com.example.martialschool.server to javafx.fxml;
    exports com.example.martialschool.window;
    opens com.example.martialschool.window to javafx.fxml;
}