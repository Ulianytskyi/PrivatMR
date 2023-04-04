module com.example.privatmr {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.privatmr to javafx.fxml;
    exports com.example.privatmr;
}