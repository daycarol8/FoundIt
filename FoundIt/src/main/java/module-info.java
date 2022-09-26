module com.foundit {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;


    opens gui to javafx.fxml;
    opens models to javafx.base;
    exports gui;
}