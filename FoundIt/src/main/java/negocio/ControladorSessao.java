package negocio;

import models.Usuario;

public class ControladorSessao {

    private Usuario usuarioLogado;
    private static ControladorCandidatura instance;

    public ControladorSessao() {
        usuarioLogado = null;
    }

    public static ControladorCandidatura getInstance() {
        if (instance == null) {
            instance = new ControladorCandidatura();
        }
        return instance;
    }

    public void login(Usuario usuario){
        setUsuarioLogado(usuario);
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
