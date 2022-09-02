package models;

public class Empresa extends usuario{

    private String nomeSocial;
    private String cnpj;
    private long telefone;
    private String endereco;
    private String descricao;
    private PorteEmpresa tamanhoEmpresa;

    public Empresa(String email, String senha, String nomeSocial, String cnpj, long telefone, String endereco, String descricao, PorteEmpresa tamanhoEmpresa) {
        super(email, senha);
        this.nomeSocial = nomeSocial;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.endereco = endereco;
        this.descricao = descricao;
        this.tamanhoEmpresa = tamanhoEmpresa;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PorteEmpresa getTamanhoEmpresa() {
        return tamanhoEmpresa;
    }

    public void setTamanhoEmpresa(PorteEmpresa tamanhoEmpresa) {
        this.tamanhoEmpresa = tamanhoEmpresa;
    }
}
