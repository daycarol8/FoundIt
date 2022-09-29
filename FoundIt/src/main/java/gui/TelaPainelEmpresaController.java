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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import models.*;
import negocio.ControladorSessao;
import negocio.ControladorVaga;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaPainelEmpresaController implements Initializable {

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
    private TableColumn<Vaga, Tecnologias> tecnologias;

    @FXML
    private TableView<Vaga> table;

    private Stage stage;
    private Scene scene;

    ControladorVaga controladorVaga = ControladorVaga.getInstance();
    ObservableList<Vaga> vagas = FXCollections.observableArrayList();
    ControladorSessao controladorSessao = ControladorSessao.getInstance();



    @FXML void logOut(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaLogin.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void mudarTelaCriarVaga(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaCriarVaga.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void mudarTelaPerfilEmpresa(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaPerfilEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void candidaturas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaCandidaturasEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void viewVaga(MouseEvent event) throws IOException {
        TableView.TableViewSelectionModel<Vaga> p = table.getSelectionModel();
        Vaga vaga = p.getSelectedItem();

        controladorVaga.setSelectedVaga(vaga);

        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaEditarVaga.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        Empresa empresa = (Empresa) controladorSessao.getUsuarioLogado();
        vagas.addAll(controladorVaga.listarVagasPorEmpresa(empresa));

        nivel.setCellValueFactory(new PropertyValueFactory<>("nivel"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        descriçao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        status.setCellValueFactory(new PropertyValueFactory<>("statusVaga"));
        contrato.setCellValueFactory(new PropertyValueFactory<>("contrato"));
        local.setCellValueFactory(new PropertyValueFactory<>("local"));
        salario.setCellValueFactory(new PropertyValueFactory<>("salario"));
        tecnologias.setCellValueFactory(new PropertyValueFactory<>("tags"));

        table.setItems(vagas);

    }

}
