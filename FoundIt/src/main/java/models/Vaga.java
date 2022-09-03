package models;
import java.util.ArrayList;

public class Vaga {

    private String nivel;

    private String descricao;

    private String local;

    private TipoContrato contrato;

    private double salario;

    private ArrayList<Tecnologias> tags;

    public Vaga(String nivel, String descricao, String local, double salario,TipoContrato contrato) {
        this.nivel = nivel;
        this.descricao = descricao;
        this.local = local;
        this.salario = salario;
        this.tags = new ArrayList<>();
        this.contrato = contrato;
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

}
