package models;

public enum PorteEmpresa {

    PEQUENA("Pequena"), MEDIA("Média"), GRANDE("Grande"), STARTUP("Startup");

    private String texto;
    PorteEmpresa(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "PorteEmpresa{" +
                "texto='" + texto + '\'' +
                '}';
    }
}
