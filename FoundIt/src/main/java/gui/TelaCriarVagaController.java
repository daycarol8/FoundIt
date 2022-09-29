package gui;

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
import negocio.ControladorSessao;
import negocio.ControladorTecnologias;
import negocio.ControladorVaga;
import org.controlsfx.control.CheckComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TelaCriarVagaController implements Initializable {

    @FXML
    private Button buttonVoltar;

    @FXML
    private Button buttonCriarVaga;

    @FXML
    private Button buttonVerVaga;

    @FXML
    private TextArea criarvagaDescricao;

    @FXML
    private TextField criarvagaNome;

    @FXML
    private TextField criarvagaNivel;

    @FXML
    private ChoiceBox<TipoContrato> criarvagaContrato;

    @FXML
    private TextField criarvagaSalario;

    @FXML
    private ChoiceBox<StatusVaga> criarvagaStatus;

    @FXML
    private CheckComboBox<Tecnologias> criarvagaTecnologia;

    @FXML
    private TextField criarvagaLocal;

    private Stage dialogStage;

    private Stage stage;

    private Scene scene;

    @FXML
    void VerVaga(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaVisualizarVaga.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaPainelEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    ControladorSessao controlSessao = ControladorSessao.getInstance();
    ControladorVaga controlVaga = ControladorVaga.getInstance();
    ControladorTecnologias controladorTecnologias = ControladorTecnologias.getInstance();
    Empresa empresa = (Empresa) controlSessao.getUsuarioLogado();

    private void Salvar(){

        String nomeVaga = criarvagaNome.getText();
        String nivelVaga = criarvagaNivel.getText();
        String localVaga = criarvagaLocal.getText();
        double salarioVaga = (double) Double.parseDouble(criarvagaSalario.getText());
        String descricaoVaga = criarvagaDescricao.getText();
        StatusVaga vagaStatus = criarvagaStatus.getSelectionModel().getSelectedItem();
        TipoContrato contratoVaga = criarvagaContrato.getSelectionModel().getSelectedItem();
        ObservableList<Tecnologias> tecnologiasVaga = criarvagaTecnologia.getCheckModel().getCheckedItems();
        ArrayList<Tecnologias> listaVagaTecno = new ArrayList<>(criarvagaTecnologia.getCheckModel().getCheckedItems());

        System.out.println(empresa);

        Vaga newVaga = new Vaga(nivelVaga, nomeVaga, descricaoVaga, localVaga, salarioVaga, listaVagaTecno, contratoVaga, empresa);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vaga criada com sucesso!");
        alert.setHeaderText("Sua vaga foi criada com as informações preenchidas.");
        alert.setContentText("confirmation");
        alert.show();

        criarvagaDescricao.setText("");
        criarvagaNome.setText("");
        criarvagaNivel.setText("");
        criarvagaSalario.setText("");
        criarvagaLocal.setText("");

    }

    private boolean verificar(){
        String erro = "";

        if( criarvagaNome.getText() == null || criarvagaNome.getText().length() == 0)
            erro += "Nome Inválido!\n";
        if(criarvagaNivel.getText() == null || criarvagaNivel.getText().length() == 0)
            erro += "Nivel Inválido!\n";
        if(criarvagaSalario.getText() == null ||criarvagaSalario.getText().length() == 0 )
            erro += "Salario Inválido!\n";
        if(criarvagaDescricao.getText() == null || criarvagaDescricao.getText().length() == 0)
            erro += "Descrição Inválido!\n";
        if(criarvagaLocal.getText() == null || criarvagaLocal.getText().length() == 0)
            erro += "Local Inválido!\n";

        if(erro.length() != 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro na criação da vaga");
            alert.setHeaderText("Existem campos inválidos. Por favor, corrija!");
            alert.setContentText(erro);
            alert.show();
            return false;
        }
        else{
            return true;
        }
    }

    @FXML
    void CriarVaga(ActionEvent event) {
        if(verificar() == true)
            Salvar();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        criarvagaTecnologia.getItems().addAll(controladorTecnologias.listar());
    }
}


