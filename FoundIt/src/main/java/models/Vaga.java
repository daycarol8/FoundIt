package models;
import java.util.ArrayList;
import java.util.Objects;

public class Vaga {

    private String nivel;

    private String descricao;

    private String local;

    private TipoContrato contrato;

    private double salario;

    private ArrayList<Tecnologias> tags;

    private Empresa empresa;
    private StatusVaga statusVaga;

    public Vaga(String nivel, String descricao, String local, double salario, TipoContrato contrato, Empresa empresa) {
        this.nivel = nivel;
        this.descricao = descricao;
        this.local = local;
        this.salario = salario;
        this.tags = new ArrayList<>();
        this.contrato = contrato;
        this.statusVaga = StatusVaga.ABERTA;
        this.empresa = empresa;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ArrayList<Tecnologias> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tecnologias> tags) {
        this.tags = tags;
    }

    public TipoContrato getContrato() {
        return contrato;
    }

    public void setContrato(TipoContrato contrato) {
        this.contrato = contrato;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public StatusVaga getStatusVaga() {
        return statusVaga;
    }

    public void setStatusVaga(StatusVaga statusVaga) {
        this.statusVaga = statusVaga;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaga vaga = (Vaga) o;
        return Double.compare(vaga.salario, salario) == 0 && Objects.equals(nivel, vaga.nivel) && Objects.equals(descricao, vaga.descricao) && Objects.equals(local, vaga.local) && contrato == vaga.contrato && Objects.equals(tags, vaga.tags) && Objects.equals(empresa, vaga.empresa) && statusVaga == vaga.statusVaga;
    }
}
