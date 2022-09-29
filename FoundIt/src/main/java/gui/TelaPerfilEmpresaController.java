package gui;

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
import models.Empresa;
import models.Pessoa;
import models.PorteEmpresa;
import models.Tecnologias;
import negocio.ControladorSessao;
import negocio.ControladorUsuario;

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
    private ChoiceBox<PorteEmpresa> empresaPorteDaEmpresaPerfil;

    @FXML
    private Button empresaEditarPerfil;

    @FXML
    private TextArea empresaDescricaoPerfil;

    private Stage dialogStage;

    private boolean editar = false;

    private Stage stage;

    private Scene scene;

    ControladorSessao controlSessao = ControladorSessao.getInstance();
    ControladorUsuario controlPerfil = ControladorUsuario.getInstance();

    Empresa empresa = (Empresa) controlSessao.getUsuarioLogado();

    @FXML

    private boolean soContemDigitos(String s) {
        System.out.println(s.matches("^\\d+$"));
        return s.matches("^\\d+$");
    }

    private void Salvar() throws ElementoNaoExisteException {

        String nomeEmpre = empresaNomePerfil.getText();
        String emailEmpre = empresaEmailPerfil.getText();
        String senhaEmpre = empresaSenhaPerfil.getText();
        String cnpjEmpre = empresaCNPJPerfil.getText();
        String enderecoEmpre = empresaEnderecoPerfil.getText();
        String descricaoEmpre = empresaDescricaoPerfil.getText();
        PorteEmpresa porteEmpre = empresaPorteDaEmpresaPerfil.getSelectionModel().getSelectedItem();
        long telefoneEmpre = (long) Integer.parseInt(empresaTelefonePerfil.getText());

        System.out.println(empresa);

        Empresa sameEmpresa = new Empresa(emailEmpre, senhaEmpre, nomeEmpre, cnpjEmpre, telefoneEmpre, enderecoEmpre, descricaoEmpre, porteEmpre);

        controlPerfil.atualizar(empresa, sameEmpresa);

        controlSessao.setUsuarioLogado(sameEmpresa);

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
    private void EditarDados(ActionEvent e) throws IOException, ElementoNaoExisteException {

        ObservableList<PorteEmpresa> porteLista = FXCollections.observableArrayList();
        empresaPorteDaEmpresaPerfil.setItems(porteLista);
        porteLista.addAll(PorteEmpresa.values());
        empresaPorteDaEmpresaPerfil.setValue(porteLista.get(0));

        if (editar && verificar()) {

            empresaNomePerfil.setEditable(false);
            empresaEmailPerfil.setEditable(false);
            empresaEnderecoPerfil.setEditable(false);
            empresaSenhaPerfil.setEditable(false);
            empresaTelefonePerfil.setEditable(false);
            empresaDescricaoPerfil.setEditable(false);
            empresaCNPJPerfil.setEditable(false);


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


            editar = true;
            empresaEditarPerfil.setText("Salvar");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        empresaNomePerfil.setEditable(false);
        empresaEmailPerfil.setEditable(false);
        empresaEnderecoPerfil.setEditable(false);
        empresaSenhaPerfil.setEditable(false);
        empresaTelefonePerfil.setEditable(false);
        empresaDescricaoPerfil.setEditable(false);
        empresaCNPJPerfil.setEditable(false);
        empresaPorteDaEmpresaPerfil.getSelectionModel().getSelectedItem();

        empresaNomePerfil.setText(empresa.getNomeSocial());
        empresaEmailPerfil.setText(empresa.getEmail());
        empresaCNPJPerfil.setText(empresa.getCnpj());
        empresaDescricaoPerfil.setText(empresa.getDescricao());
        empresaEnderecoPerfil.setText(empresa.getEndereco());
        empresaTelefonePerfil.setText(String.valueOf(empresa.getTelefone()));
        empresaSenhaPerfil.setText(empresa.getSenha());
        empresaPorteDaEmpresaPerfil.setValue(empresa.getTamanhoEmpresa());

    }

    @FXML
    void Voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaPainelEmpresa.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
