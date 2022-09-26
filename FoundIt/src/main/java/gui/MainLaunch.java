package gui;

import Exceptions.ElementoJaExisteException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.*;
import negocio.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MainLaunch extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainLaunch.class.getResource("TelaLogin.fxml"));

        Scene scene = new Scene(fxmlLoader.load());

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.setResizable(false);
        stage.show();
    }
    static ControladorVaga controladorVaga = ControladorVaga.getInstance();
    static ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
    static ControladorSessao controladorSessao = ControladorSessao.getInstance();

    public static void main(String[] args) throws ElementoJaExisteException {
        Pessoa p1 = new Pessoa("camilealheiro@gmail.com", "camile123", "Camile Alheiro", 123456789, "Desenvolvedora Júnior", "Olinda, Rio Doce, 534", "81 94002-8922", LocalDate.of(2003, 3, 12));
        Pessoa p2 = new Pessoa("gabyanisio@gmail.com", "gaby123", "Gabrielly Anísio", 98767543, "Desenvolvedora Júnior", "Olinda, Rio Doce, 674", "81 98790-0898", LocalDate.of(2004, 12, 10));
        Empresa e1 = new Empresa("google@gmail.com", "senha123", "Google", "12.345.678/0001-90", 88276597, "Rua Cristovão Colombo", "Empresa com anos de experiência no mercado :)", PorteEmpresa.GRANDE);
        Empresa e2 = new Empresa("amazon@gmail.com", "senha345", "Amazon", "34.567.890/0001.12", 76543245, "Avenida Rosa e Silva", "Empresa nova no mercado", PorteEmpresa.MEDIA);

        ArrayList<Tecnologias> tec = new ArrayList<>();
        ArrayList<Tecnologias> tec2 = new ArrayList<>();
        Tecnologias t1 = new Tecnologias("Java");
        Tecnologias t2 = new Tecnologias("Python");
        Tecnologias t3 = new Tecnologias("C");
        tec.add(t1);
        tec.add(t2);
        tec2.add(t2);
        tec2.add(t3);

        Vaga v1 = new Vaga("Senior","Vaga Senior Java e Python", "Vaga para trabalhar em um projeto", "Recife-PE", 7002, tec, TipoContrato.SERVICO, e1);
        Vaga v2 = new Vaga("Pleno", "Vaga Pleno C","Vaga para trabalhar por 8 meses", "Salvador-BA", 5000, tec2, TipoContrato.ESTAGIO, e2);

        Candidatura c1 = new Candidatura(LocalDateTime.of(2022, 10, 22, 19, 0), StatusCandidatura.ENVIADO, v1, p1);
        Candidatura c2 = new Candidatura(LocalDateTime.of(2022, 11, 10, 20, 0), StatusCandidatura.ENVIADO, v2, p1);
//        controladorVaga.inserir(v1);
//        controladorVaga.inserir(v2);

        //controladorUsuario.inserir(p1);
        //controladorUsuario.inserir(e2);
        //controladorUsuario.inserir(p2);

        controladorSessao.setUsuarioLogado(e1);
        System.out.println(controladorVaga.listarVagasAtivas());
        launch();
    }
}