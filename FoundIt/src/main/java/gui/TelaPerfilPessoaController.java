package gui;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Pessoa;
import negocio.ControladorSessao;
import negocio.ControladorUsuario;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class TelaPerfilPessoaController implements Initializable {

    @FXML private Button botaoEditar;
    @FXML private Button botaoVoltar;
    @FXML private TextField textoCPfPerfil;
    @FXML private TextField textoDataNascimentoPerfil;
    @FXML private TextField textoEmailPessoaPerfil;
    @FXML private TextField textoEnderecoPessoaPerfil;
    @FXML private TextField textoNomePessoaPerfil;
    @FXML private TextArea textoResumoPerfil;
    @FXML private TextField textoSenhaPessoaPerfil;
    @FXML private TextField textoTelefonePessoaPerfil;

    private Stage stage;
    private Scene scene;

    ControladorSessao controlSessao = ControladorSessao.getInstance();
    ControladorUsuario controlPerfil = ControladorUsuario.getInstance();

    Pessoa pessoa = (Pessoa) controlSessao.getUsuarioLogado();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textoCPfPerfil.setText(String.valueOf(pessoa.getCpf()));
        textoCPfPerfil.setEditable(false);

        textoEmailPessoaPerfil.setText(pessoa.getEmail());
        textoEmailPessoaPerfil.setEditable(false);

        textoEnderecoPessoaPerfil.setText(pessoa.getEndereco());
        textoEnderecoPessoaPerfil.setEditable(false);

        textoNomePessoaPerfil.setText(pessoa.getNome());
        textoNomePessoaPerfil.setEditable(false);

        textoResumoPerfil.setText(pessoa.getResumo());
        textoResumoPerfil.setEditable(false);
        textoResumoPerfil.setWrapText(true);

        textoSenhaPessoaPerfil.setText(pessoa.getSenha());
        textoSenhaPessoaPerfil.setEditable(false);

        textoTelefonePessoaPerfil.setText(pessoa.getTelefone());
        textoTelefonePessoaPerfil.setEditable(false);

        textoDataNascimentoPerfil.setText(pessoa.getDataNascimento().toString());
        textoDataNascimentoPerfil.setEditable(false);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    @FXML
    public void irCandidaturas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaCandidaturaUsuario.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void editarPerfil(MouseEvent event) throws ElementoNaoExisteException {

        botaoEditar.setText("Salvar");

        textoEmailPessoaPerfil.setEditable(true);
        textoEnderecoPessoaPerfil.setEditable(true);
        textoNomePessoaPerfil.setEditable(true);
        textoResumoPerfil.setEditable(true);
        textoSenhaPessoaPerfil.setEditable(true);
        textoTelefonePessoaPerfil.setEditable(true);

        if(botaoEditar.getText().equals("Salvar") && event.getClickCount() == 1) {

            String nomePessoa = textoNomePessoaPerfil.getText();
            String emailPessoa = textoEmailPessoaPerfil.getText();
            String senhaPessoa = textoSenhaPessoaPerfil.getText();
            long cpfPessoa = (long) Integer.parseInt(textoCPfPerfil.getText());
            String enderecoPessoa = textoEnderecoPessoaPerfil.getText();
            String resumoPessoa = textoResumoPerfil.getText();
            LocalDate dataNascimentoPess = LocalDate.parse(textoDataNascimentoPerfil.getText());
            String telefonePessoa = textoTelefonePessoaPerfil.getText();

            Pessoa editPess = new Pessoa(emailPessoa, senhaPessoa, nomePessoa, cpfPessoa,resumoPessoa, enderecoPessoa, telefonePessoa, dataNascimentoPess);

            controlPerfil.atualizar(pessoa, editPess);

            controlSessao.setUsuarioLogado(editPess);


            textoEmailPessoaPerfil.setEditable(false);
            textoEnderecoPessoaPerfil.setEditable(false);
            textoNomePessoaPerfil.setEditable(false);
            textoResumoPerfil.setEditable(false);
            textoResumoPerfil.setWrapText(true);
            textoSenhaPessoaPerfil.setEditable(false);
            textoTelefonePessoaPerfil.setEditable(false);

            botaoEditar.setText("Editar");
        }

    }

    public void voltarTela(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(MainLaunch.class.getResource("TelaListaVagas.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean showFXMLCadastroClienteDialog (Pessoa outraPessoa) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(TelaCadastroPessoaController.class.getResource("TelaPerfilCadastroPessoa"));
        AnchorPane page = (AnchorPane) loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Perfil Pessoal");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        TelaCadastroPessoaController controller = loader.getController();
        controller.setPessoa(pessoa);

        dialogStage.showAndWait();

        return controller.isConfirmarClicado();
    }

}
