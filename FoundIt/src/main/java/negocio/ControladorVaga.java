package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.*;

import java.util.ArrayList;
import java.util.List;

public class ControladorVaga {
    private IRepositorioGenerico<Vaga> repositorioVaga;
    private static ControladorVaga instance;
    public ControladorVaga() {
        this.repositorioVaga = new RepositorioGenerico<>("vagas.dat");
    }

    public static ControladorVaga getInstance() {
        if (instance == null) {
            instance = new ControladorVaga();
        }
        return instance;
    }

    public List<Vaga> listarVagasAtivas(){
        List<Vaga> lista = new ArrayList<>();
        for(Vaga temp: repositorioVaga.listar()){
            if(temp.getStatusVaga() == StatusVaga.ABERTA){
                lista.add(temp);
            }
        }

        return lista;
    }

    public List<Vaga> listarVagasPorEmpresa(Empresa empresa){
        List<Vaga> lista = new ArrayList<>();
        for(Vaga temp: repositorioVaga.listar()){
            if(temp.getEmpresa().equals(empresa)){
                lista.add(temp);
            }
        }

        return lista;
    }

    public void inserir(Vaga obj) throws ElementoJaExisteException {
        repositorioVaga.inserir(obj);
    }

    public List<Vaga> listar() {
        return repositorioVaga.listar();
    }

    public void remover(Vaga obj) throws ElementoNaoExisteException {
        repositorioVaga.remover(obj);
    }

    public void atualizar(Vaga newObj) throws ElementoNaoExisteException {
        repositorioVaga.atualizar(newObj);
    }
}
