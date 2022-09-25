package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import models.StatusVaga;
import models.Tecnologias;
import models.TipoContrato;
import models.Vaga;
import negocio.ControladorVaga;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaPainelEmpresaController implements Initializable {

    @FXML public Button btnV;
    @FXML public Button btnNew;
    @FXML public Button btnLo;

    @FXML public Button btnPe;

    @FXML
    private TableColumn<Vaga, TipoContrato> contrato;

    @FXML
    private TableColumn<Vaga, String> descriçao;

    @FXML
    private TableColumn<Vaga, String> local;

    @FXML
    private TableColumn<Vaga, String> nivel;

    @FXML
    private TableColumn<Vaga, Double> salario;

    @FXML
    private TableColumn<Vaga, StatusVaga> status;

    @FXML
    private TableColumn<Vaga, String> titulo;

    @FXML
    private TableColumn<Vaga, ArrayList<Tecnologias>> tecnologias;

    @FXML
    private TableView<Vaga> table;

    private Stage stage;
    private Scene scene;

    ControladorVaga controladorVaga = ControladorVaga.getInstance();
    ObservableList<Vaga> vagas = FXCollections.observableArrayList();



    @FXML
    public void mudarTelaTeste(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaPerfilPessoa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        nivel.setCellValueFactory(new PropertyValueFactory<Vaga, String>("nivel"));
        titulo.setCellValueFactory(new PropertyValueFactory<Vaga, String>("titulo"));
        descriçao.setCellValueFactory(new PropertyValueFactory<Vaga, String>("descricao"));
        status.setCellValueFactory(new PropertyValueFactory<Vaga, StatusVaga>("statusVaga"));
        contrato.setCellValueFactory(new PropertyValueFactory<Vaga, TipoContrato>("contrato"));
        local.setCellValueFactory(new PropertyValueFactory<Vaga, String>("local"));
        salario.setCellValueFactory(new PropertyValueFactory<Vaga, Double>("salario"));
        tecnologias.setCellValueFactory(new PropertyValueFactory<Vaga, ArrayList<Tecnologias>>("tags"));

        table.setItems((ObservableList<Vaga>) controladorVaga.listarVagasPorEmpresa());
    }

}
