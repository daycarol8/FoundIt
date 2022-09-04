package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.Candidatura;

import java.util.List;

public class ControladorTecnologias {
    private IRepositorioGenerico<Candidatura> repositorioTecnologias;

    private static ControladorTecnologias instance;

    public ControladorTecnologias() {
        this.repositorioTecnologias = new RepositorioGenerico<>("tecnologias.dat");
    }

    public static ControladorTecnologias getInstance() {
        if (instance == null) {
            instance = new ControladorTecnologias();
        }
        return instance;
    }

    public void inserir(Candidatura obj) throws ElementoJaExisteException {
        repositorioTecnologias.inserir(obj);
    }

    public List<Candidatura> listar() {
        return repositorioTecnologias.listar();
    }

    public void remover(Candidatura obj) throws ElementoNaoExisteException {
        repositorioTecnologias.remover(obj);
    }

    public void atualizar(Candidatura newObj) throws ElementoNaoExisteException {
        repositorioTecnologias.atualizar(newObj);
    }
}
