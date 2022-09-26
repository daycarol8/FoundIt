package gui;

import Exceptions.ElementoNaoExisteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.*;
import negocio.ControladorCandidatura;
import negocio.ControladorSessao;
import negocio.ControladorVaga;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class TelaCandidaturasEmpresaController implements Initializable {

    @FXML
    private TableView<Candidatura> candidatosTable;
    @FXML
    private TableColumn<Candidatura, Pessoa> candidatoColumn;

    @FXML
    private TableColumn<Candidatura, LocalDateTime> dataColumn;

    @FXML
    private TableColumn<Candidatura, StatusCandidatura> statusColumn;

    @FXML
    private TableColumn<Candidatura, Vaga> vagaColumn;

    @FXML
    private Label enderecoLabel;

    @FXML
    private Label nascimentoLabel;

    @FXML
    private Label nomeLabel;

    @FXML
    private Label resumoLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label telefoneLabel;

    @FXML
    private Label tituloLabel;

    @FXML
    private Label nivelLabel;

    @FXML
    private Label tagsLabel;

    @FXML
    private Button voltarButton;

    @FXML
    private Button statusButton;

    @FXML
    void selectCandidato(MouseEvent event) {
        TableView.TableViewSelectionModel<Candidatura> p = candidatosTable.getSelectionModel();
        Candidatura candidatura = p.getSelectedItem();

        nomeLabel.setText(candidatura.getCandidato().getNome());
        telefoneLabel.setText(candidatura.getCandidato().getTelefone());
        nascimentoLabel.setText(candidatura.getCandidato().getDataNascimento().toString());
        enderecoLabel.setText(candidatura.getCandidato().getEndereco());
        resumoLabel.setText(candidatura.getCandidato().getResumo());
        statusLabel.setText(candidatura.getStatus().toString());

        tituloLabel.setText(candidatura.getVaga().getTitulo());
        nivelLabel.setText(candidatura.getVaga().getNivel());
        tagsLabel.setText(candidatura.getVaga().getTags().toString());

    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) voltarButton.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TelaPerfilEmpresa.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Perfil");
        stage.show();
    }

    @FXML
    void changeStatus(ActionEvent event) throws ElementoNaoExisteException {

        Candidatura candidatura = candidatosTable.getSelectionModel().getSelectedItem();

        if(candidatura != null){
            List<StatusCandidatura> choices = new ArrayList<>();
            choices.add(StatusCandidatura.ANALISE);
            choices.add(StatusCandidatura.ESCOLHIDO);
            choices.add(StatusCandidatura.NAOESCOLHIDO);

            ChoiceDialog<StatusCandidatura> dialog = new ChoiceDialog<>(candidatura.getStatus(), choices);
            dialog.setTitle("Modificar o status da candidatura");
            dialog.setHeaderText("Modificar o status da candidatura");
            dialog.setContentText("Escolha o novo status:");

            // Traditional way to get the response value.
            Optional<StatusCandidatura> result = dialog.showAndWait();
            if (result.isPresent()){
                candidatura.setStatus(result.get());
                controladorCandidatura.atualizar(candidatosTable.getSelectionModel().getSelectedItem(), candidatura);
                statusLabel.setText(candidatura.getStatus().toString());
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Por favor, escolha uma candidatura na tabela");
            alert.show();
        }


    }


    ControladorCandidatura controladorCandidatura = ControladorCandidatura.getInstance();
    ControladorSessao controladorSessao = ControladorSessao.getInstance();

    ObservableList<Candidatura> candidaturas = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Empresa empresa = (Empresa) controladorSessao.getUsuarioLogado();
        candidaturas.addAll(controladorCandidatura.listarCandidaturasDaEmpresa(empresa));
        System.out.println(candidaturas);

        candidatoColumn.setCellValueFactory(new PropertyValueFactory<>("candidato"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        vagaColumn.setCellValueFactory(new PropertyValueFactory<>("vaga"));

        candidatosTable.setItems(candidaturas);

    }

}
