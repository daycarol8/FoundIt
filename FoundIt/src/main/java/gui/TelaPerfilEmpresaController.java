package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Empresa;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaPerfilEmpresaController implements Initializable{

    @FXML
    private TextField empresaNomePerfil;

    @FXML
    private Button empresaVoltarPerfil;

    @FXML
    private TextField empresaEmailPerfil;

    @FXML
    private TextField empresaEnderecoPerfil;

    @FXML
    private TextField empresaSenhaPerfil;

    @FXML
    private TextField empresaTelefonePerfil;

    @FXML
    private TextField empresaCNPJPerfil;

    @FXML
    private TextField empresaPorteDaEmpresaPerfil;

    @FXML
    private Button empresaEditarPerfil;

    @FXML
    private Button empresaPainelEmpresaPerfil;
    @FXML
    private TextArea empresaDescricaoPerfil;

    private Stage dialogStage;

    private Empresa empresa;

    private boolean editar = false;

    private Stage stage;

    private Scene scene;

    @FXML

    private boolean soContemDigitos(String s) {
        System.out.println(s.matches("^\\d+$"));
        return s.matches("^\\d+$");
    }

    private void Salvar(){

    }

    private boolean verificar(){
        String erro = "";

            if(empresaNomePerfil.getText() == null ||empresaNomePerfil.getText().length() == 0)
                erro += "Nome Inválido!\n";
            if(empresaEmailPerfil.getText() == null || empresaEmailPerfil.getText().length() == 0)
                erro += "Email Inválido!\n";
            if(empresaSenhaPerfil.getText() == null || empresaSenhaPerfil.getText().length() == 0)
                erro += "Senha Inválida\n";
            if(empresaTelefonePerfil.getText() == null ||empresaTelefonePerfil.getText().length() == 0 )
                erro += "Telefone Inválido!\n";
            if(empresaCNPJPerfil.getText() == null || empresaCNPJPerfil.getText().length() == 0 || !soContemDigitos(empresaCNPJPerfil.getText()))
                erro += "CNPJ Inválido!\n";
            if(empresaEnderecoPerfil.getText() == null || empresaEnderecoPerfil.getText().length() == 0)
                erro += "Endereço Inválido!\n";
            if(empresaDescricaoPerfil.getText() == null || empresaDescricaoPerfil.getText().length() == 0)
                erro += "Descrição Inválido!\n";

            if(erro.length() != 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erro na edição do Perfil");
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
    private void EditarDados(ActionEvent e) throws IOException {

        if (editar && verificar()) {
            empresaNomePerfil.setEditable(false);
            empresaEmailPerfil.setEditable(false);
            empresaEnderecoPerfil.setEditable(false);
            empresaSenhaPerfil.setEditable(false);
            empresaTelefonePerfil.setEditable(false);
            empresaDescricaoPerfil.setEditable(false);
            empresaCNPJPerfil.setEditable(false);
            empresaPorteDaEmpresaPerfil.setEditable(false);

            editar = false;
            empresaEditarPerfil.setText("Editar");
            Salvar();

        } else {
            empresaNomePerfil.setEditable(true);
            empresaEmailPerfil.setEditable(true);
            empresaEnderecoPerfil.setEditable(true);
            empresaSenhaPerfil.setEditable(true);
            empresaTelefonePerfil.setEditable(true);
            empresaDescricaoPerfil.setEditable(true);
            empresaCNPJPerfil.setEditable(true);
            empresaPorteDaEmpresaPerfil.setEditable(true);

            editar = true;
            empresaEditarPerfil.setText("Salvar");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){

        empresaNomePerfil.setEditable(false);
        empresaEmailPerfil.setEditable(false);
        empresaEnderecoPerfil.setEditable(false);
        empresaSenhaPerfil.setEditable(false);
        empresaTelefonePerfil.setEditable(false);
        empresaDescricaoPerfil.setEditable(false);
        empresaCNPJPerfil.setEditable(false);
        empresaPorteDaEmpresaPerfil.setEditable(false);

        empresaNomePerfil.setText("arg0");
        empresaEmailPerfil.setText("arg1");
        empresaEnderecoPerfil.setText("arg2");
        empresaSenhaPerfil.setText("arg3");
        empresaTelefonePerfil.setText("arg4");
        empresaDescricaoPerfil.setText("arg5");
        empresaCNPJPerfil.setText("arg6");
        empresaPorteDaEmpresaPerfil.setText("arg7");

    }
    @FXML
    void AvancaPainelEmpresa(ActionEvent event) {

    }

    @FXML
    void Voltar(ActionEvent event) {

    }

}
