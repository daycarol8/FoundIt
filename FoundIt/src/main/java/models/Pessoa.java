package models;

import java.io.File;
import java.time.LocalDate;

public class Pessoa extends usuario {
    private String nome;
    private long cpf;
    private String resumo;
    private String endereco;
    private String telefone;
    private LocalDate dataNascimento;
    private File curriculo;

    public Pessoa(String email, String senha, String nome, long cpf, String resumo, String endereco, String telefone, LocalDate dataNascimento, File curriculo) {
        super(email, senha);
        this.nome = nome;
        this.cpf = cpf;
        this.resumo = resumo;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.curriculo = curriculo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public File getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(File curriculo) {
        this.curriculo = curriculo;
    }
}
