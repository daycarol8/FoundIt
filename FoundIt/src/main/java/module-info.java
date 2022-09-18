module com.foundit {
    requires javafx.controls;
    requires javafx.fxml;


    opens gui to javafx.fxml;
    opens models to javafx.base;
    exports gui;
}