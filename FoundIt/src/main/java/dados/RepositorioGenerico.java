package dados;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioGenerico<T> {

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


    public void inserir(T novoObj){
        if (!this.elementos.contains(novoObj)) {
            this.elementos.add(novoObj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

    public List<T> listar() {
        return Collections.unmodifiableList(this.elementos);
    }


    public void remover(T obj){
        if (this.elementos.contains(obj)) {
            this.elementos.remove(this.elementos.indexOf(obj));
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }


    public void atualizar(T newObj){
        if (this.elementos.contains(newObj)) {
            int indice = this.elementos.indexOf(newObj);
            this.elementos.set(indice, newObj);
        }

        RepositorioFileUtil.salvarArquivo(elementos, this.filename);
    }

}
