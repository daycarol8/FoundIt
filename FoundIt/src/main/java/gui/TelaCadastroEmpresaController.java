package gui;

import Exceptions.ElementoJaExisteException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Empresa;
import models.PorteEmpresa;
import negocio.ControladorUsuario;

import java.net.URL;
import java.util.ResourceBundle;

public class TelaCadastroEmpresaController implements Initializable {


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

    ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<PorteEmpresa> porteLista = FXCollections.observableArrayList();
        EscolhaPorte.setItems(porteLista);
        porteLista.addAll(PorteEmpresa.values());
        EscolhaPorte.setValue(porteLista.get(0));
    }

    @FXML
    public void confirmacao(ActionEvent ev) {

        if(validarDados()) {

            String nomeEmpre = TextoNome.getText();
            String emailEmpre = TextoEmail.getText();
            String senhaEmpre = TextoSenha.getText();
            String cnpjEmpre = TextoCNPJ.getText();
            String enderecoEmpre = TextoEndereco.getText();
            String descricaoEmpre = TextoDescricao.getText();
            PorteEmpresa porteEmpre = EscolhaPorte.getValue();
            long telefoneEmpre = (long) Integer.parseInt(TextoTelefone.getText());

            System.out.println(empresa);

            Empresa empre = new Empresa(emailEmpre, senhaEmpre, nomeEmpre, cnpjEmpre, telefoneEmpre, enderecoEmpre, descricaoEmpre, porteEmpre);

            System.out.println(empre);
            try {
                controladorUsuario.inserir(empre);
            } catch (ElementoJaExisteException e) {
                System.out.println("Empresa já existente");
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro no cadastramento");
                alerta.setHeaderText("Empresa já cadastrada");
                alerta.setContentText("Essa empresa já foi cadastrada. Tente de novo!");
                alerta.showAndWait();
                throw new RuntimeException(e);
            }


            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Empresa Cadastrada");
            alerta.setHeaderText("Empresa Cadastrada!");
            alerta.setContentText("Parabéns! Sua Empresa foi cadastrada com sucesso!");
            alerta.showAndWait();
            final Node source = (Node) ev.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            confirmarClicado = true;
            //dialogStage.close();
        }
    }

    @FXML
    public void cancelamento(ActionEvent e) {
        final Node source = (Node) e.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private boolean soContemDigitos(String s) {
        System.out.println(s.matches("^\\d+$"));
        return s.matches("^\\d+$");
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

//    public Empresa getEmpresa() {
//        return empresa;
//    }
//
//    public void setEmpresa(Empresa empresa) {
//        this.empresa = empresa;
//    }

}
