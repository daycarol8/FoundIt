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
        stage.setTitle("FoundIt");
        stage.setResizable(false);
        stage.show();
    }
    static ControladorVaga controladorVaga = ControladorVaga.getInstance();
    static ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
    static ControladorSessao controladorSessao = ControladorSessao.getInstance();
    static  ControladorTecnologias controladorTecnologias = ControladorTecnologias.getInstance();

    public static void main(String[] args) throws ElementoJaExisteException {
        Pessoa p1 = new Pessoa("camilealheiro@gmail.com", "camile123", "Camile Alheiro", 123456789, "Desenvolvedora Júnior", "Olinda, Rio Doce, 534", "81 94002-8922", LocalDate.of(2003, 3, 12));
        Pessoa p2 = new Pessoa("gabyanisio@gmail.com", "gaby123", "Gabrielly Anísio", 98767543, "Desenvolvedora Júnior", "Olinda, Rio Doce, 674", "81 98790-0898", LocalDate.of(2004, 12, 10));
        Empresa e1 = new Empresa("google@gmail.com", "senha123", "Google", "12.345.678/0001-90", 88276597, "Rua Cristovão Colombo", "Empresa com anos de experiência no mercado :)", PorteEmpresa.GRANDE);
        Empresa e2 = new Empresa("amazon@gmail.com", "senha345", "Amazon", "34.567.890/0001.12", 76543245, "Avenida Rosa e Silva", "Empresa nova no mercado", PorteEmpresa.MEDIA);
        Empresa e3 = new Empresa("startup@gmail.com", "senha123", "AiFood", "12.345.618/0001-90", 842276597, "Rua Cristovão Colombo", "Startup em crescimento, maior na área de comida do Brasil", PorteEmpresa.STARTUP);
        Empresa e4 = new Empresa("tecnologia@gmail.com", "senha123", "Lojinha", "42.345.678/0001-90", 31276597, "Rua Cristovão Colombo", "Lojinha de departamento querendo ampliar para vendas online", PorteEmpresa.PEQUENA);

        ArrayList<Tecnologias> tec = new ArrayList<>();
        ArrayList<Tecnologias> tec2 = new ArrayList<>();
        Tecnologias t1 = new Tecnologias("Java");
        Tecnologias t2 = new Tecnologias("Python");
        Tecnologias t3 = new Tecnologias("C");
        Tecnologias t4 = new Tecnologias("C#");
        Tecnologias t5 = new Tecnologias("Angular");
        Tecnologias t6 = new Tecnologias("PHP");
        Tecnologias t7 = new Tecnologias("React");
        Tecnologias t8 = new Tecnologias("Front-End");
        Tecnologias t9 = new Tecnologias("Unity");
        Tecnologias t10 = new Tecnologias("Arduino");
        Tecnologias t11 = new Tecnologias("Android");
        Tecnologias t12 = new Tecnologias("Flutter");
        Tecnologias t13 = new Tecnologias("Swift");
        Tecnologias t14 = new Tecnologias("C++");
        Tecnologias t15 = new Tecnologias("Dart");
        Tecnologias t16 = new Tecnologias("SQL");
        Tecnologias t17 = new Tecnologias("Vue.js");
        Tecnologias t18 = new Tecnologias("Ruby");


        tec.add(t1);
        tec.add(t2);
        tec2.add(t2);
        tec2.add(t3);

        ArrayList<Tecnologias> tc = new ArrayList<>();
        ArrayList<Tecnologias> tc2 = new ArrayList<>();
        ArrayList<Tecnologias> tc3 = new ArrayList<>();
        ArrayList<Tecnologias> tc4 = new ArrayList<>();

        tc.add(t8);
        tc.add(t7);
        tc2.add(t1);
        tc2.add(t4);
        tc3.add(t16);
        tc3.add(t6);
        tc4.add(t14);
        tc4.add(t9);
        tc4.add(t4);

        Vaga v1 = new Vaga("Senior","Vaga Senior Java e Python", "Vaga para trabalhar em um projeto", "Recife-PE", 7002, tec, TipoContrato.SERVICO, e1);
        Vaga v2 = new Vaga("Pleno", "Vaga Pleno C","Vaga para trabalhar por 8 meses", "Salvador-BA", 5000, tec2, TipoContrato.ESTAGIO, e2);
        Vaga v3 = new Vaga("Junior", "Vaga Front-End JR","Vaga para trabalhar por 8 meses", "Remoto", 2500, tec2, TipoContrato.ESTAGIO, e3);
        Vaga v4 = new Vaga("Estagio", "Estágio em Tecnologia","Aqui você terá a oportunidade de se desenvolver na área de Tecnologia, com mentoria e acompanhamento. ", "Sao Paulo/Remoto", 1500, tc, TipoContrato.ESTAGIO, e1);
        Vaga v5 = new Vaga("Pleno", "Vaga PL","Vaga pleno BackEnd", "Manaus-AM", 8000, tc2, TipoContrato.PJ, e4);
        Vaga v6 = new Vaga("Sênior", "Vaga Senior ","Vaga Senior", "Salvador-BA", 6500, tc3, TipoContrato.CLT, e4);
        Vaga v7 = new Vaga("Pleno", "Vaga Pleno","Vaga Pleno", "Recife-PE", 7000, tc4, TipoContrato.PJ, e3);

        Candidatura c1 = new Candidatura(LocalDateTime.of(2022, 10, 22, 19, 0), StatusCandidatura.ENVIADO, v1, p1);
        Candidatura c2 = new Candidatura(LocalDateTime.of(2022, 11, 10, 20, 0), StatusCandidatura.ENVIADO, v2, p1);


        launch();
    }
}