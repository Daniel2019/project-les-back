package com.nerdoteca.api.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamentos")
public class FormaPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pag_id")
    private long id;

    @Column(name = "pag_numero_cartao")
    private int numeroCartao;

    @Column(name = "pag_marca")
    private String marcaCartao;

    @Column(name = "pag_cvc")
    private int cvc;

    @Column(name = "pag_nome_titular")
    private String nomeTitular;

    @Column(name = "pag_cpf")
    private String cpf;

    @Column(name = "pag_observacoes")
    private String observacoes;

    public FormaPagamento() {
    }

    public FormaPagamento(long id, int numeroCartao, String marcaCartao, int cvc, String nomeTitular, String cpf, String observacoes) {
        this.id = id;
        this.numeroCartao = numeroCartao;
        this.marcaCartao = marcaCartao;
        this.cvc = cvc;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.observacoes = observacoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getMarcaCartao() {
        return marcaCartao;
    }

    public void setMarcaCartao(String marcaCartao) {
        this.marcaCartao = marcaCartao;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" +
                "id=" + id +
                ", numeroCartao=" + numeroCartao +
                ", marcaCartao='" + marcaCartao + '\'' +
                ", cvc=" + cvc +
                ", nomeTitular='" + nomeTitular + '\'' +
                ", cpf='" + cpf + '\'' +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}