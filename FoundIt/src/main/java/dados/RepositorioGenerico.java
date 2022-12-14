package dados;
import Exceptions.ElementoJaExisteException;
import Exceptions.ElementoNaoExisteException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioGenerico<T> implements IRepositorioGenerico<T>{

    protected List<T> elementos;
    private String filename;

    @SuppressWarnings("unchecked")
    public RepositorioGenerico(String filename) {
        this.filename = filename;
        this.elementos = new ArrayList<>();

        Object listaElementos = RepositorioFileUtil.lerDoArquivo(this.filename);
        if (listaElementos != null && listaElementos instanceof List<?>){
            this.elementos = (List<T>) listaElementos;
        }
    }


    @Override
    public void inserir(T novoObj) throws ElementoJaExisteException {
        if (!this.elementos.contains(novoObj)) {
            this.elementos.add(novoObj);
        }
        else {
            throw new ElementoJaExisteException(novoObj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }


    @Override
    public List<T> listar() {
        return Collections.unmodifiableList(this.elementos);
    }


    @Override
    public void remover(T obj) throws ElementoNaoExisteException {
        if (this.elementos.contains(obj)) {
            this.elementos.remove(this.elementos.indexOf(obj));
        }
        else {
            throw new ElementoNaoExisteException(obj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }


    @Override
    public void atualizar(T oldObj, T newObj) throws ElementoNaoExisteException{
        if (this.elementos.contains(oldObj)) {
            int indice = this.elementos.indexOf(oldObj);
            this.elementos.set(indice, newObj);
        }
        else {
            throw new ElementoNaoExisteException(newObj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

}
