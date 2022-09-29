package gui;

import Exceptions.ElementoJaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.*;
import negocio.ControladorCandidatura;
import negocio.ControladorSessao;
import negocio.ControladorVaga;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaVisualizarVagaController implements Initializable {
    @FXML
    private TextArea areaInfContrato;

    @FXML
    private TextArea areaInfEmpresa;

    @FXML
    private TextArea areaInfLocal;

    @FXML
    private TextArea areaInfNivel;

    @FXML
    private TextArea areaInfSalario;

    @FXML
    private Button botaoEditar;

    @FXML
    private Button botaoQueroCandidatar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea descricaoTeste;

    @FXML
    private Label statusVaga;

    @FXML
    private Label tituloVaga;

    ControladorCandidatura controladorCandidatura = ControladorCandidatura.getInstance();
    ControladorSessao controladorSessao = ControladorSessao.getInstance();
    ControladorVaga controladorVaga = ControladorVaga.getInstance();

    Vaga vaga = controladorVaga.getSelectedVaga();

    Usuario usuarioLogado = controladorSessao.getUsuarioLogado();
    Pessoa pessoaLogada;
    Empresa empresaLogada;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(usuarioLogado instanceof Pessoa) {
            pessoaLogada = (Pessoa) controladorSessao.getUsuarioLogado();
            statusVaga.setText("Status - " + vaga.getStatusVaga().toString());
            tituloVaga.setText(vaga.getTitulo());

            descricaoTeste.setText(vaga.getDescricao());
            descricaoTeste.setEditable(false);
            descricaoTeste.setWrapText(true);

            areaInfEmpresa.setText(vaga.getEmpresa().getNomeSocial() + "\n" + vaga.getEmpresa().getCnpj() + "\n" + vaga.getEmpresa().getDescricao() + "\n" +
                    vaga.getEmpresa().getTelefone() + "\n" + vaga.getEmpresa().getEndereco());
            areaInfEmpresa.setEditable(false);
            areaInfEmpresa.setWrapText(true);

            areaInfLocal.setText(vaga.getLocal());
            areaInfLocal.setEditable(false);

            areaInfNivel.setText(vaga.getNivel());
            areaInfNivel.setEditable(false);

            areaInfSalario.setText(String.valueOf(vaga.getSalario()));
            areaInfSalario.setEditable(false);

            areaInfContrato.setText("Tipo de contrato: " + vaga.getContrato().toString());
            areaInfContrato.setEditable(false);

            System.out.println("ja candidato?");
            System.out.println(controladorCandidatura.verificarPessoaJaCandidata(vaga,pessoaLogada));
            System.out.println(controladorCandidatura.listarCandidaturasPorVaga(vaga));
            if(controladorCandidatura.verificarPessoaJaCandidata(vaga, pessoaLogada) == true) {
                botaoQueroCandidatar.setDisable(true);
            }

            botaoEditar.setVisible(false);

        } else {
            empresaLogada = (Empresa) controladorSessao.getUsuarioLogado();
            statusVaga.setText("Status - " + vaga.getStatusVaga().toString());
            tituloVaga.setText(vaga.getTitulo());

            descricaoTeste.setText(vaga.getDescricao());
            descricaoTeste.setEditable(false);
            descricaoTeste.setWrapText(true);

            areaInfEmpresa.setText(vaga.getEmpresa().getNomeSocial() + "\n" + vaga.getEmpresa().getCnpj() + "\n" + vaga.getEmpresa().getDescricao() + "\n" +
                    vaga.getEmpresa().getTelefone() + "\n" + vaga.getEmpresa().getEndereco());
            areaInfEmpresa.setEditable(false);
            areaInfEmpresa.setWrapText(true);

            areaInfLocal.setText(vaga.getLocal());
            areaInfLocal.setEditable(false);

            areaInfNivel.setText(vaga.getNivel());
            areaInfNivel.setEditable(false);

            areaInfSalario.setText(String.valueOf(vaga.getSalario()));
            areaInfSalario.setEditable(false);

            areaInfContrato.setText("Tipo de contrato: " + vaga.getContrato().toString());
            areaInfContrato.setEditable(false);

            botaoQueroCandidatar.setVisible(false);

        }

    }

    @FXML
    public void candidatarVaga(ActionEvent event) throws ElementoJaExisteException {
        try {
            controladorCandidatura.candidatarVaga(pessoaLogada, vaga);
            botaoQueroCandidatar.setDisable(true);
        } catch (ElementoJaExisteException e) {
            System.out.println("Você já se candidatou!");
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro na candidatura");
            alerta.setHeaderText("Candidatura já realizada, não é possível se candidatar novamente.");
            alerta.setContentText("Não é possível se candidatar novamente.");
            alerta.showAndWait();
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void voltarListadeVagas(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) botaoVoltar.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TelaListaVagas.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void editarVaga(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) botaoEditar.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TelaEditarVaga.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
