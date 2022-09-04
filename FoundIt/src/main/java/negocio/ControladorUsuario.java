package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.Usuario;

import java.util.List;

public class ControladorUsuario {
    private IRepositorioGenerico<Usuario> repositorioUsuario;
    private static ControladorUsuario instance;

    public ControladorUsuario() {
        this.repositorioUsuario = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }
        return instance;
    }

    public void editarUsuario(Usuario novo){

    }

    public void inserir(Usuario obj) throws ElementoJaExisteException {
        repositorioUsuario.inserir(obj);
    }

    public List<Usuario> listar() {
        return repositorioUsuario.listar();
    }

    public void remover(Usuario obj) throws ElementoNaoExisteException {
        repositorioUsuario.remover(obj);
    }

    public void atualizar(Usuario newObj) throws ElementoNaoExisteException {
        repositorioUsuario.atualizar(newObj);
    }
}
