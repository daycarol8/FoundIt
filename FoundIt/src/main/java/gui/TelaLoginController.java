package gui;

import Exceptions.CredenciaisErradas;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import models.Empresa;
import models.Pessoa;
import negocio.ControladorSessao;
import negocio.ControladorUsuario;

import java.io.IOException;

public class TelaLoginController {
    @FXML
    TextField inputEmail;

    @FXML
    PasswordField inputSenha;

    @FXML
    Button buttonLogin;

    @FXML
    Label buttonCadastrarEmpresa;

    @FXML
    Label buttonCadastraPessoa;

    @FXML
    public void cadastrarPessoa() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) buttonCadastraPessoa.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TelaCadastroPessoa.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void cadastrarEmpresa() throws IOException {
        Stage stage;
        Parent root;

        stage = (Stage) buttonCadastrarEmpresa.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("TelaCadastroEmpresa.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    static private ControladorSessao controladorSessao = ControladorSessao.getInstance();

    private boolean validarDados() {
        String erro = "";

        if(inputEmail.getText() == null || inputEmail.getText().length() == 0)
            erro += "Campo email vazio\n";
        if(inputSenha.getText() == null || inputSenha.getText().length() == 0)
            erro += "Campo senha vazio\n";

        if(erro.length() == 0)
            return true;
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no login");
            alert.setHeaderText("Existem campos vazios");
            alert.setContentText(erro);
            alert.show();
            return false;
        }
    }
    @FXML
    public void realizarLogin() throws IOException {

        Stage stage;
        Parent root;
        String email = inputEmail.getText();
        String senha = inputSenha.getText();
        if(validarDados()){
            try {
                controladorSessao.login(email, senha);
                System.out.println("teste1");

            } catch (CredenciaisErradas e) {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setHeaderText("Email ou senha estão errados.");
                alerta.setContentText("Tente novamente.");
                alerta.showAndWait();
                throw new RuntimeException(e);
            }

            if(controladorSessao.getUsuarioLogado() instanceof Pessoa){
                root = FXMLLoader.load(getClass().getResource("TelaListaVagas.fxml"));
            } else{
                root = FXMLLoader.load(getClass().getResource("Tela.fxml"));
            }

            stage = (Stage) buttonCadastraPessoa.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }
}
