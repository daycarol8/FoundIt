package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ControladorCandidatura {
    private IRepositorioGenerico<Candidatura> repositorioCandidatura;

    private static ControladorCandidatura instance;

    private ControladorCandidatura() {
        this.repositorioCandidatura = new RepositorioGenerico<>("candidaturas.dat");
    }

    public static ControladorCandidatura getInstance() {
        if (instance == null) {
            instance = new ControladorCandidatura();
        }
        return instance;
    }

    public void candidatarVaga(Pessoa usuario, Vaga vaga) throws ElementoJaExisteException {
        LocalDateTime now = LocalDateTime.now();
        Candidatura novaCandidatura = new Candidatura(now, StatusCandidatura.ANALISE, vaga, usuario);

        repositorioCandidatura.inserir(novaCandidatura);
    }

    public boolean verificarPessoaJaCandidata (Vaga vaga, Pessoa pessoa) {
        System.out.println(pessoa);
        for(Candidatura temp : listarCandidaturasPorVaga(vaga)) {

            if(temp.getCandidato().equals(pessoa)) {
                return true;
            }
        }
        //pegar a lista de candidatos do repositorio e verificar se é igual a pessoa e a vaga
        return false;
    }

    public List<Candidatura> listarCandidaturasDoUsuario(Pessoa pessoa){
        List<Candidatura> lista = new ArrayList<>();

        for(Candidatura temp: repositorioCandidatura.listar()){
            if(temp.getCandidato().equals(pessoa)){
                lista.add(temp);
            }
        }

        return lista;
    }

    public List<Candidatura> listarCandidaturasDaEmpresa(Empresa empresa){
        List<Candidatura> lista = new ArrayList<>();

        for(Candidatura temp: repositorioCandidatura.listar()){
            if(temp.getVaga().getEmpresa().equals(empresa)){
                lista.add(temp);
            }
        }

        return lista;
    }

    public List<Candidatura> listarCandidaturasPorVaga(Vaga vaga){
        List<Candidatura> lista = new ArrayList<>();

        for(Candidatura temp: repositorioCandidatura.listar()){
            if(temp.getVaga().equals(vaga)){
                lista.add(temp);
            }
        }

        return lista;
    }

    public void inserir(Candidatura obj) throws ElementoJaExisteException {
        repositorioCandidatura.inserir(obj);
    }

    public List<Candidatura> listar() {
        return repositorioCandidatura.listar();
    }

    public void remover(Candidatura obj) throws ElementoNaoExisteException {
        repositorioCandidatura.remover(obj);
    }

    public void atualizar(Candidatura newObj) throws ElementoNaoExisteException {
        repositorioCandidatura.atualizar(newObj);
    }
}
