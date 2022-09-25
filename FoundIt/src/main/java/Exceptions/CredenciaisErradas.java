package Exceptions;

public class CredenciaisErradas extends Exception{
    private Object elemento;

    public CredenciaisErradas(Object obj) {
        super("Email ou senha está errado, por favor tente novamente");
        this.elemento = obj;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }
}
