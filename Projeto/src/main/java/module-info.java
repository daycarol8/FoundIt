module com.foundit.projeto {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.foundit.projeto to javafx.fxml;
    exports com.foundit.projeto;
}