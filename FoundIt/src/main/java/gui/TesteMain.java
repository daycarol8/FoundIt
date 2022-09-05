package gui;

import Exceptions.ElementoJaExisteException;
import models.*;
import negocio.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TesteMain {

    public static void main(String[] args) {

        // INSTÂNCIAS CLASSES BÁSICAS

        Pessoa p1 = new Pessoa("camilealheiro@gmail.com", "camile123", "Camile Alheiro", 123456789,
                "Desenvolvedora Júnior", "Olinda, Rio Doce, 534", "81 94002-8922", LocalDate.of(2003, 3, 12));
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

        Vaga v1 = new Vaga("Sênior", "Vaga para trabalhar em um projeto", "Recife-PE", 7002, tec, TipoContrato.SERVICO, e1);
        Vaga v2 = new Vaga("Pleno", "Vaga para trabalhar por 8 meses", "Salvador-BA", 5000, tec2, TipoContrato.ESTAGIO, e2);

        Candidatura c1 = new Candidatura(LocalDateTime.of(2022, 10, 22, 19, 0), StatusCandidatura.ENVIADO, v1, p1);
        Candidatura c2 = new Candidatura(LocalDateTime.of(2022, 11, 10, 20, 0), StatusCandidatura.ENVIADO, v2, p1);

        // REPOSITÓRIO
        ControladorPessoa controlUsu = new ControladorPessoa();
        ControladorEmpresa controlEmpresa = new ControladorEmpresa();
        ControladorVaga controlVaga = new ControladorVaga();
        ControladorCandidatura controlCandidatura = new ControladorCandidatura();
        ControladorTecnologias controlTec = new ControladorTecnologias();
        ControladorSessao controlSes = new ControladorSessao();

//

        try {
            controlUsu.inserir(p1);
            controlUsu.inserir(p2);


            controlEmpresa.inserir(e1);
            controlEmpresa.inserir(e2);


            controlVaga.inserir(v1);
            controlVaga.inserir(v2);


            controlCandidatura.inserir(c1);
            controlCandidatura.inserir(c2);

        } catch (ElementoJaExisteException jaExiste) {
            System.out.println("Elemento já existente");
            jaExiste.printStackTrace();
        }


    }
}