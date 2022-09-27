package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.Candidatura;
import models.Tecnologias;

import java.util.List;

public class ControladorTecnologias {
    private IRepositorioGenerico<Tecnologias> repositorioTecnologias;

    private static ControladorTecnologias instance;

    private ControladorTecnologias() {
        this.repositorioTecnologias = new RepositorioGenerico<>("tecnologias.dat");
    }

    public static ControladorTecnologias getInstance() {
        if (instance == null) {
            instance = new ControladorTecnologias();
        }
        return instance;
    }

    public void inserir(Tecnologias obj) throws ElementoJaExisteException {
        repositorioTecnologias.inserir(obj);
    }

    public List<Tecnologias> listar() {
        return repositorioTecnologias.listar();
    }

    public void remover(Tecnologias obj) throws ElementoNaoExisteException {
        repositorioTecnologias.remover(obj);
    }

    public void atualizar(Tecnologias oldObj, Tecnologias newObj) throws ElementoNaoExisteException {
        repositorioTecnologias.atualizar(oldObj, newObj);
    }
}
