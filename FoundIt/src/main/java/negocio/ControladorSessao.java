package negocio;

import Exceptions.CredenciaisErradas;
import models.Empresa;
import models.Usuario;

public class ControladorSessao {

    private Usuario usuarioLogado;
    private static ControladorSessao instance;

    public ControladorSessao() {
        usuarioLogado = null;
    }

    public static ControladorSessao getInstance() {
        if (instance == null) {
            instance = new ControladorSessao();
        }
        return instance;
    }

    public void login(String email, String senha) throws CredenciaisErradas {
        ControladorUsuario controladorUsuario = ControladorUsuario.getInstance();
        Usuario usuario = null;
        for(Usuario temp : controladorUsuario.listar()){
            if(email.equals(temp.getEmail()) && senha.equals(temp.getSenha())){
                usuario = temp;
                System.out.println("teste login");
                System.out.println(temp instanceof Empresa);
                if(temp instanceof Empresa){
                    System.out.println(((Empresa) temp).getNomeSocial());
                }

            }
        }

        if(usuario == null){
            throw new CredenciaisErradas(usuario);
        } else{
            setUsuarioLogado(usuario);
        }

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
