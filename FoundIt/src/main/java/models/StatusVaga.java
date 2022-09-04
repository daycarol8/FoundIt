package models;

public enum StatusVaga {
    ABERTA("Aberta"), FINALIZADA("Finalizada"), CANCELADA("Cancelada");

    private String statusVaga;

    StatusVaga(String statusVaga) {
        this.statusVaga = statusVaga;
    }

    @Override
    public String toString() {
        return "statusVaga{" + "Status da Vaga ='" + statusVaga + '\'' + '}';
    }
}
