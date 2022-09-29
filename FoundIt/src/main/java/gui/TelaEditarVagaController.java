package gui;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.*;
import negocio.ControladorCandidatura;
import negocio.ControladorSessao;
import negocio.ControladorTecnologias;
import negocio.ControladorVaga;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class TelaEditarVagaController implements Initializable {

    @FXML
    private Button botaoConfirmarEdição;

    @FXML
    private TextField editarTitulo;

    @FXML
    private Button botaoVoltar;

    @FXML
    private TextArea editarDescricao;

    @FXML
    private TextField editarLocal;

    @FXML
    private ChoiceBox<TipoContrato> editarContrato;

    @FXML
    private TextField editarNivel;

    @FXML
    private TextField editarSalario;

    @FXML
    private CheckComboBox<Tecnologias> editarTecnologias;

    ControladorSessao controladorSessao = ControladorSessao.getInstance();
    ControladorVaga controladorVaga = ControladorVaga.getInstance();
    ControladorTecnologias controladorTecnologias = ControladorTecnologias.getInstance();

    Vaga vaga = controladorVaga.getSelectedVaga();

    Empresa empresaLogada = (Empresa) controladorSessao.getUsuarioLogado();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editarTitulo.setText(vaga.getTitulo());
        editarTitulo.setEditable(true);

        editarNivel.setText(vaga.getNivel());
        editarNivel.setEditable(true);

        editarLocal.setText(vaga.getLocal());
        editarLocal.setEditable(true);

        editarTecnologias.getItems().addAll(controladorTecnologias.listar());

        editarSalario.setText(vaga.toStringSalario());
        editarSalario.setEditable(true);

        editarDescricao.setText(vaga.getDescricao());
        editarDescricao.setEditable(true);
        editarDescricao.setWrapText(true);

        ObservableList<TipoContrato> contratoEditarLista = FXCollections.observableArrayList();
        editarContrato.setItems(contratoEditarLista);
        contratoEditarLista.addAll(TipoContrato.values());
        editarContrato.setValue(contratoEditarLista.get(0));
    }

    private boolean validarDados() {
        String erro = "";

        if(editarTitulo.getText() == null || editarTitulo.getText().length() == 0)
            erro += "Título Inválido!\n";
        if(editarDescricao.getText() == null || editarDescricao.getText().length() == 0)
            erro += "Descrição Inválida!\n";
        if(editarNivel.getText() == null || editarNivel.getText().length() == 0)
            erro += "Nível inválido\n";
        if(editarLocal.getText() == null || editarLocal.getText().length() == 0 )
            erro += "Local Inválido!\n";
        if(editarSalario.getText() == null || editarSalario.getText().length() == 0)
            erro += "Salário Inválido!\n";

        if(erro.length() == 0)
            return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro na edição");
            alert.setHeaderText("Existem campos inválidos. Por favor, corrija!");
            alert.setContentText(erro);
            alert.show();
            return false;
        }
    }

    @FXML
    public void confirmarEdicao(ActionEvent ev) throws IOException {

        if(validarDados()) {
            String tituloVaga = editarTitulo.getText();
            String descricaoVaga = editarDescricao.getText();
            String nivelVaga = editarNivel.getText();
            String localVaga = editarLocal.getText();
            double salarioVaga = (double) Double.parseDouble(editarSalario.getText());
            TipoContrato contratoVaga = editarContrato.getSelectionModel().getSelectedItem();

            ObservableList<Tecnologias> tecnologiaVaga = editarTecnologias.getCheckModel().getCheckedItems();
            ArrayList<Tecnologias> listaVagaTecnologia = new ArrayList<>(editarTecnologias.getCheckModel().getCheckedItems());


            Vaga newVaga = new Vaga(nivelVaga, tituloVaga, descricaoVaga, localVaga, salarioVaga, listaVagaTecnologia, contratoVaga, empresaLogada);

            try {
                controladorVaga.atualizar(vaga, newVaga);
            } catch (ElementoNaoExisteException e) {
                System.out.println("Vaga não existente");
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro na edição");
                alerta.setHeaderText("Vaga não existente");
                alerta.setContentText("Vaga não existente. Tente de novo!");
                alerta.showAndWait();
                throw new RuntimeException(e);
            }


            Stage stage;
            Parent root;

            stage = (Stage) botaoVoltar.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("TelaVisualizarVaga.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    public void voltarVisualizarTela(ActionEvent e) throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) botaoVoltar.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TelaVisualizarVaga.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
