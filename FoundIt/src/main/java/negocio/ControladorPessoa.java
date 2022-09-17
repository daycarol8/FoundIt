package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.Pessoa;

import java.util.List;

public class ControladorPessoa {
    private IRepositorioGenerico<Pessoa> repositorioPessoa;
    private static ControladorPessoa instance;

    private ControladorPessoa() {
        this.repositorioPessoa = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorPessoa getInstance() {
        if (instance == null) {
            instance = new ControladorPessoa();
        }
        return instance;
    }

    public void editarUsuario(Pessoa novo){

    }

    public void inserir(Pessoa obj) throws ElementoJaExisteException {
        repositorioPessoa.inserir(obj);
    }

    public List<Pessoa> listar() {
        return repositorioPessoa.listar();
    }

    public void remover(Pessoa obj) throws ElementoNaoExisteException {
        repositorioPessoa.remover(obj);
    }

    public void atualizar(Pessoa newObj) throws ElementoNaoExisteException {
        repositorioPessoa.atualizar(newObj);
    }


    public IRepositorioGenerico<Pessoa> getRepositorioUsuario() {
        return repositorioPessoa;
    }
}
