package gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Pessoa;
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

    Pessoa pessoa = new Pessoa("pessoa@gmail.com", "12345", "Pessoa Sobrenome", 1234567, "Procuro emprego", "Alguma rua do Brasil", "345234", LocalDate.of(2000, 5, 13));

    ControladorUsuario controlPerfil = ControladorUsuario.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textoCPfPerfil.setText(String.valueOf(pessoa.getCpf()));
        textoCPfPerfil.setEditable(false);
        //TextoCPf.setDisable(true);

        textoEmailPessoaPerfil.setText(pessoa.getEmail());
        textoEmailPessoaPerfil.setEditable(false);

        textoEnderecoPessoaPerfil.setText(pessoa.getEndereco());
        textoEnderecoPessoaPerfil.setEditable(false);

        textoNomePessoaPerfil.setText(pessoa.getNome());
        textoNomePessoaPerfil.setEditable(false);

        textoResumoPerfil.setText(pessoa.getResumo());
        textoResumoPerfil.setEditable(false);

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

    public void editarPerfil() {

        if(pessoa != null) {

        }
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
