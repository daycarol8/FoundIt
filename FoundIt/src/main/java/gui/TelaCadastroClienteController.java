package gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Empresa;
import models.PorteEmpresa;

public class TelaCadastroClienteController extends Application {


    @FXML private TextField TextoNome;
    @FXML private TextField TextoEmail;
    @FXML private TextField TextoSenha;
    @FXML private TextField TextoTelefone;
    @FXML private TextField TextoCNPJ;
    @FXML private TextField TextoEndereco;
    @FXML private TextField TextoDescricao;
    @FXML private ChoiceBox<PorteEmpresa> EscolhaPorte;
    @FXML private Button BotaoCadastrar;
    @FXML private Button BotaoCancelar;

    private Stage dialogStage;
    private boolean confirmarClicado = false;
    private Empresa empresa;

//    public static void main(String[] args) {
//        launch(args);
//    }

    @Override
    public void start(Stage primaryStage) {

    }

    @FXML
    public void confirmacao() {

        if(validarDados()) {
            empresa.setNomeSocial(TextoNome.getText());
            empresa.setEmail(TextoEmail.getText());
            empresa.setSenha(TextoSenha.getText());
            empresa.setCnpj(TextoCNPJ.getText());
            empresa.setEndereco(TextoEndereco.getText());
            empresa.setDescricao(TextoDescricao.getText());
            empresa.setTamanhoEmpresa(EscolhaPorte.getValue());
            empresa.setTelefone(Integer.parseInt(TextoTelefone.getText()));

            confirmarClicado = true;
            dialogStage.close();
        }
    }

    @FXML
    public void cancelamento() {
        dialogStage.close();
    }

    private boolean soContemDigitos(String s) {
        return s.matches("\\d");
    }
    private boolean validarDados() {
        String erro = "";

        if(TextoNome.getText() == null || TextoNome.getText().length() == 0)
            erro += "Nome Inválido!\n";
        if(TextoEmail.getText() == null || TextoEmail.getText().length() == 0)
            erro += "Email Inválido!\n";
        if(TextoSenha.getText() == null || TextoSenha.getText().length() == 0)
            erro += "Senha Inválida\n";
        if(TextoTelefone.getText() == null || TextoTelefone.getText().length() == 0 || !soContemDigitos(TextoTelefone.getText()))
            erro += "Telefone Inválido!\n";
        if(TextoCNPJ.getText() == null || TextoCNPJ.getText().length() == 0)
            erro += "CNPJ Inválido!\n";
        if(TextoEndereco.getText() == null || TextoEndereco.getText().length() == 0)
            erro += "Endereço Inválido!\n";
        if(TextoDescricao.getText() == null || TextoDescricao.getText().length() == 0)
            erro += "Descrição Inválida!\n";
        if(EscolhaPorte.getValue() == null)
            erro += "Porte Inválido!\n";

        if(erro.length() == 0)
            return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastramento");
            alert.setHeaderText("Existem campos inválidos. Por favor, corrija!");
            alert.setContentText(erro);
            alert.show();
            return false;
        }
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isConfirmarClicado() {
        return confirmarClicado;
    }

    public void setConfirmarClicado(boolean confirmarClicado) {
        this.confirmarClicado = confirmarClicado;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
