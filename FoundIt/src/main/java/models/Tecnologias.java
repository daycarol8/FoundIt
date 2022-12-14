package models;

import java.io.Serializable;
import java.util.Objects;

public class Tecnologias implements Serializable {

    private String nome;

    public Tecnologias(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tecnologias that = (Tecnologias) o;
        return Objects.equals(nome, that.nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
