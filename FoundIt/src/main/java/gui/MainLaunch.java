package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import negocio.ControladorEmpresa;

import java.io.IOException;

public class MainLaunch extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLaunch.class.getResource("TelaCadastroEmpresa.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.setTitle("Cadastramento da Empresa");
        stage.setResizable(false);
        stage.show();
    }

    static ControladorEmpresa controlEmpresa = new ControladorEmpresa();

    public static void main(String[] args) {
        launch();
    }
}
