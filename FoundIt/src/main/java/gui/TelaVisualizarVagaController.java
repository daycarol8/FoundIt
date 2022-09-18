package gui;

import Exceptions.ElementoJaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.stage.Window;
import models.*;
import negocio.ControladorCandidatura;
import negocio.ControladorPessoa;
import negocio.ControladorVaga;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private Tab botaoInfContrato;

    @FXML
    private Tab botaoInfEmpresa;

    @FXML
    private Tab botaoInfNivel;

    @FXML
    private Tab botaoInfSalario;

    @FXML
    private Button botaoQueroCandidatar;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea descricaoTeste;

    @FXML
    private Label statusVaga;

    ControladorCandidatura controladorCandidatura = ControladorCandidatura.getInstance();

    ArrayList<Tecnologias> tec = new ArrayList<>();
    Empresa e1 = new Empresa("google@gmail.com", "senha123", "Google", "12.345.678/0001-90", 88276597, "Rua Cristovão Colombo", "Empresa com anos de experiência no mercado :)", PorteEmpresa.GRANDE);
    Vaga v1 = new Vaga("Sênior", "Vaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalharVaga para trabalhar em um projeto Vaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projetoVaga para trabalhar em um projeto", "Recife-PE", 7002, tec, TipoContrato.SERVICO, e1);
    Pessoa p1 = new Pessoa("camilealheiro@gmail.com", "camile123", "Camile Alheiro", 123456789,
               "Desenvolvedora Júnior", "Olinda, Rio Doce, 534", "81 94002-8922", LocalDate.of(2003, 3, 12));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        statusVaga.setText("Status - " + v1.getStatusVaga().toString());

        descricaoTeste.setText(v1.getDescricao());
        descricaoTeste.setEditable(false);
        descricaoTeste.setWrapText(true);

        areaInfEmpresa.setText(v1.getEmpresa().getNomeSocial() + "\n" + v1.getEmpresa().getCnpj() + "\n" + v1.getEmpresa().getDescricao() + "\n" +
                v1.getEmpresa().getTelefone() + "\n" + v1.getEmpresa().getEndereco());
        areaInfEmpresa.setEditable(false);
        areaInfEmpresa.setWrapText(true);

        areaInfLocal.setText(v1.getLocal());
        areaInfLocal.setEditable(false);

        areaInfNivel.setText(v1.getNivel());
        areaInfNivel.setEditable(false);

        areaInfSalario.setText(String.valueOf(v1.getSalario()));
        areaInfSalario.setEditable(false);

        areaInfContrato.setText("Tipo de contrato: " + v1.getContrato().toString());
        areaInfContrato.setEditable(false);

        if(controladorCandidatura.verificarPessoaJaCandidata(v1, p1) == true) {
            botaoQueroCandidatar.setDisable(true);
        }
    }

    @FXML
    public void candidatarVaga(ActionEvent event) throws ElementoJaExisteException {
        try {
            controladorCandidatura.candidatarVaga(p1, v1);
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
        root = FXMLLoader.load(getClass().getResource("TelaCadastroEmpresa.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
