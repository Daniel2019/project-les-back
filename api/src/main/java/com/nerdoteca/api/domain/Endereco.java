package com.nerdoteca.api.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private long id;

    @Column(name = "end_nome_endereco")
    private String nomeEndereco;

    @Column(name = "end_tipo_endereco")
    private String tipoEndereco;

    @Column(name = "end_tipo_residencia")
    private String tipoResidencia;

    @Column(name = "end_cep")
    private String cep;

    @Column(name = "end_logradouro")
    private String logradouro;

    @Column(name = "end_tipo_logradouro")
    private String tipoLogradouro;

    @Column(name = "end_numero")
    private int numero;

    @Column(name = "end_bairro")
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "end_cid_id")
    private Cidade cidade;

    @Column(name = "end_observacoes")
    private String observacoes;

    public Endereco() {
    }

    public Endereco(long id, String nomeEndereco, String tipoEndereco, String tipoResidencia, String cep, String logradouro, String tipoLogradouro, int numero, String bairro, Cidade cidade, String observacoes) {
        this.id = id;
        this.nomeEndereco = nomeEndereco;
        this.tipoEndereco = tipoEndereco;
        this.tipoResidencia = tipoResidencia;
        this.cep = cep;
        this.logradouro = logradouro;
        this.tipoLogradouro = tipoLogradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.observacoes = observacoes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeEndereco() {
        return nomeEndereco;
    }

    public void setNomeEndereco(String nomeEndereco) {
        this.nomeEndereco = nomeEndereco;
    }

    public String getTipoEndereco() {
        return tipoEndereco;
    }

    public void setTipoEndereco(String tipoEndereco) {
        this.tipoEndereco = tipoEndereco;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", nomeEndereco='" + nomeEndereco + '\'' +
                ", tipoEndereco='" + tipoEndereco + '\'' +
                ", tipoResidencia='" + tipoResidencia + '\'' +
                ", cep='" + cep + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", tipoLogradouro='" + tipoLogradouro + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade=" + cidade +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }
}