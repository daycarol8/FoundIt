package models;

public enum TipoContrato {

    PJ("PJ"), CLT("CLT"), ESTAGIO("Estágio"), SERVICO("Serviço");

    private String contrato;

    TipoContrato(String contrato) {
        this.contrato = contrato;
    }

    @Override
    public String toString() {
        return contrato;
    }
}
