package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
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
    private TextField criarvagaContrato;

    @FXML
    private TextField criarvagaSalario;

    @FXML
    private TextField criarvagaStatus;

    @FXML
    private TextField criarvagaTecnologia;

    @FXML
    private TextField criarvagaLocal;

    @FXML
    void VerVaga(ActionEvent event) {

    }

    @FXML
    void Voltar(ActionEvent event) {

    }

    private void Salvar(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vaga criada com sucesso!");
        alert.setHeaderText("Sua vaga foi criada com as informações preenchidas.");
        alert.setContentText("confirmation");
        alert.show();

        criarvagaDescricao.setText("");
        criarvagaNome.setText("");
        criarvagaNivel.setText("");
        criarvagaContrato.setText("");
        criarvagaSalario.setText("");
        criarvagaStatus.setText("");
        criarvagaTecnologia.setText("");
        criarvagaLocal.setText("");
    }

    private boolean verificar(){
        String erro = "";

        if( criarvagaNome.getText() == null || criarvagaNome.getText().length() == 0)
            erro += "Nome Inválido!\n";
        if(criarvagaNivel.getText() == null || criarvagaNivel.getText().length() == 0)
            erro += "Nivel Inválido!\n";
        if(criarvagaContrato.getText() == null || criarvagaContrato.getText().length() == 0)
            erro += "Contrato Inválida\n";
        if(criarvagaSalario.getText() == null ||criarvagaSalario.getText().length() == 0 )
            erro += "Salario Inválido!\n";
        if(criarvagaStatus.getText() == null || criarvagaStatus.getText().length() == 0 )
            erro += "Status Inválido!\n";
        if(criarvagaTecnologia.getText() == null ||criarvagaTecnologia.getText().length() == 0)
            erro += "Tecnologia Inválido!\n";
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

    }
}


