package dados;

import java.util.List;

import Exceptions.ElementoNaoExisteException;
import Exceptions.ElementoJaExisteException;

public interface IRepositorioGenerico<T> {

    void inserir(T obj) throws ElementoJaExisteException;

    List<T> listar();

    void remover(T obj) throws ElementoNaoExisteException;

    void atualizar(T newObj) throws ElementoNaoExisteException;

}