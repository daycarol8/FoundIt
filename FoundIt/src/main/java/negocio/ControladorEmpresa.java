package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.Empresa;

import java.util.List;

public class ControladorEmpresa {
    private IRepositorioGenerico<Empresa> repositorioEmpresa;

    private static ControladorEmpresa instance;

    private ControladorEmpresa() {
        this.repositorioEmpresa = new RepositorioGenerico<>("empresas.dat");
    }

    public static ControladorEmpresa getInstance() {
        if (instance == null) {
            instance = new ControladorEmpresa();
        }
        return instance;
    }

    public void inserir(Empresa obj) throws ElementoJaExisteException {
        repositorioEmpresa.inserir(obj);
    }

    public List<Empresa> listar() {
        return repositorioEmpresa.listar();
    }

    public void remover(Empresa obj) throws ElementoNaoExisteException {
        repositorioEmpresa.remover(obj);
    }

    public void atualizar(Empresa newObj) throws ElementoNaoExisteException {
        repositorioEmpresa.atualizar(newObj);
    }
}
