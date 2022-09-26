package gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.*;
import negocio.ControladorCandidatura;
import negocio.ControladorSessao;
import negocio.ControladorUsuario;
import negocio.ControladorVaga;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class TelaCandidaturaUsuarioController implements Initializable {

@FXML private Button btnVoltar;

    @FXML
    private TableColumn<Candidatura, Vaga> vaga;

    @FXML
    private TableColumn<Candidatura, StatusCandidatura> status;

    @FXML
    private TableColumn<Candidatura, LocalDateTime> data;

    @FXML
    private TableColumn<Candidatura, Pessoa> candidato;

    @FXML
    private TableView<Candidatura> table;

    private Stage stage;
    private Scene scene;

    ControladorCandidatura controladorCandidatura = ControladorCandidatura.getInstance();
    ControladorSessao controladorSessao = ControladorSessao.getInstance();
    ObservableList<Candidatura> candidaturas = FXCollections.observableArrayList();



    @FXML void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaListaVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {

        Pessoa pessoa = (Pessoa) controladorSessao.getUsuarioLogado();
        candidaturas.addAll(controladorCandidatura.listarCandidaturasDoUsuario(pessoa));

        vaga.setCellValueFactory(new PropertyValueFactory<>("vaga"));
        data.setCellValueFactory(new PropertyValueFactory<>("data"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        candidato.setCellValueFactory(new PropertyValueFactory<>("candidato"));

        table.setItems(candidaturas);

    }
}
