package models;

import java.io.Serializable;
import java.util.Objects;

public abstract class Usuario implements Serializable {
    private String email;
    private String senha;


    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha);
    }

    @Override
    public String toString() {
        return "usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
