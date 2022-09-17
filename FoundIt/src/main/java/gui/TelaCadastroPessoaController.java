package gui;

import Exceptions.ElementoJaExisteException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Pessoa;
import negocio.ControladorPessoa;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TelaCadastroPessoaController implements Initializable {

    @FXML private TextField textoNomePessoa;
    @FXML private TextField textoEmailPessoa;
    @FXML private TextField textoSenhaPessoa;
    @FXML private TextField textoTelefonePessoa;
    @FXML private TextField textoCPf;
    @FXML private TextField textoEnderecoPessoa;
    @FXML private TextField textoResumo;
    @FXML private DatePicker pickDataNascimento;
    @FXML private Button botaoCadastrarPessoa;
    @FXML private Button botaoCancelarPessoa;

    private Stage dialogStage;
    private boolean confirmarClicado = false;
    private Pessoa pessoa;

    private Stage stage;
    private Scene scene;


    ControladorPessoa controladorPessoa = MainLaunch.controlPessoa;


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

        if(textoNomePessoa.getText() == null || textoNomePessoa.getText().length() == 0)
            erro += "Nome Inválido!\n";
        if(textoEmailPessoa.getText() == null || textoEmailPessoa.getText().length() == 0)
            erro += "Email Inválido!\n";
        if(textoSenhaPessoa.getText() == null || textoSenhaPessoa.getText().length() == 0)
            erro += "Senha Inválida\n";
        if(textoTelefonePessoa.getText() == null || textoTelefonePessoa.getText().length() == 0 )
            erro += "Telefone Inválido!\n";
        if(textoCPf.getText() == null || textoCPf.getText().length() == 0 || !soContemDigitos(textoCPf.getText()))
            erro += "CPF Inválido!\n";
        if(textoEnderecoPessoa.getText() == null || textoEnderecoPessoa.getText().length() == 0)
            erro += "Endereço Inválido!\n";
        if(textoResumo.getText() == null || textoResumo.getText().length() == 0)
            erro += "Resumo Inválido!\n";
        if(pickDataNascimento.getValue() == null)
            erro += "Data inválida!\n";


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

    @FXML
    public void confirmacao(ActionEvent ev) {

        if(validarDados()) {

            String nomePessoa = textoNomePessoa.getText();
            String emailPessoa = textoEmailPessoa.getText();
            String senhaPessoa = textoSenhaPessoa.getText();
            long cpfPessoa = (long) Integer.parseInt(textoCPf.getText());
            String enderecoPessoa = textoEnderecoPessoa.getText();
            String resumoPessoa = textoResumo.getText();
            LocalDate dataNascimentoPess = pickDataNascimento.getValue();
            String telefonePessoa = textoTelefonePessoa.getText();

            //System.out.println(empresa);

            Pessoa pess = new Pessoa(emailPessoa, senhaPessoa, nomePessoa, cpfPessoa, resumoPessoa, enderecoPessoa, telefonePessoa, dataNascimentoPess);

            System.out.println(pess);
            try {
                controladorPessoa.inserir(pess);
            } catch (ElementoJaExisteException e) {
                System.out.println("Pessoa já existente");
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Erro no cadastramento");
                alerta.setHeaderText("Pessoa já cadastrada");
                alerta.setContentText("Essa pessoa já foi cadastrada. Tente de novo!");
                alerta.showAndWait();
                throw new RuntimeException(e);
            }


            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Pessoa Cadastrada");
            alerta.setHeaderText("Pessoa Cadastrada!");
            alerta.setContentText("Parabéns! Você foi cadastrado com sucesso!");
            alerta.showAndWait();
            final Node source = (Node) ev.getSource();
            final Stage stage = (Stage) source.getScene().getWindow();
            stage.close();
            confirmarClicado = true;
            //dialogStage.close();
        }
    }

//    public void getDate(ActionEvent e) {
//        LocalDate data = pickDataNascimento.getValue();
//    }

    @FXML
    public void mudarTelaTeste(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaPerfilPessoa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate data = pickDataNascimento.getValue();
    }

    public TextField getTextoNomePessoa() {
        return textoNomePessoa;
    }

    public void setTextoNomePessoa(TextField textoNomePessoa) {
        this.textoNomePessoa = textoNomePessoa;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
