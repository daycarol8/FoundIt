package negocio;

import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;
import dados.IRepositorioGenerico;
import dados.RepositorioGenerico;
import models.Empresa;
import models.Pessoa;
import models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class ControladorUsuario {
    private IRepositorioGenerico<Usuario> repositorioUsuario;

    private static ControladorUsuario instance;

    private ControladorUsuario() {
        this.repositorioUsuario = new RepositorioGenerico<>("usuarios.dat");
    }

    public static ControladorUsuario getInstance() {
        if (instance == null) {
            instance = new ControladorUsuario();
        }
        return instance;
    }

    public List<Pessoa> listarPessoas(){
        List<Pessoa> usuariosPessoa = new ArrayList<>();
        for(Usuario temp: listar()){
            if(temp instanceof Pessoa){
                usuariosPessoa.add((Pessoa)temp);
            }
        }
        return usuariosPessoa;
    }

    public List<Empresa> listarEmpresas(){
        List<Empresa> usuariosEmpresa = new ArrayList<>();
        for(Usuario temp: listar()){
            if(temp instanceof Empresa){
                usuariosEmpresa.add((Empresa) temp);
            }
        }
        return usuariosEmpresa;
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

    public void atualizar(Usuario oldObj, Usuario newObj) throws ElementoNaoExisteException {
        repositorioUsuario.atualizar(oldObj, newObj);
    }
}
