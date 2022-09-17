package negocio;

import models.Empresa;
import models.Usuario;

public class ControladorSessao {

    private Usuario usuarioLogado;
    private static ControladorSessao instance;

    public ControladorSessao() {
        usuarioLogado = null;
    }

    private static ControladorSessao getInstance() {
        if (instance == null) {
            instance = new ControladorSessao();
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

    public String getTipoUsuario(){
        if(getUsuarioLogado() instanceof Empresa){
            return "empresa";
        } else{
            return "pessoa";
        }
    }
}
