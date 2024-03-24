package com.nerdoteca.api.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "cli_cpf")
    private String cpf;

    @Column(name = "cli_nome")
    private String nome;

    @Column(name = "cli_sobrenome")
    private String sobrenome;

    @Column(name = "cli_email")
    private String email;

    @Column(name = "cli_senha")
    private String senha;

    @Column(name = "cli_endereco_residencial")
    private Endereco enderecoResidencial;

    @Column(name = "cli_genero")
    private String genero;

    @Column(name = "cli_data_nascimento")
    private String dataNascimento;

    @Column(name = "cli_status")
    private String status;
    private List<Cupom> cupons;
    private List<Endereco> enderecosEntrega;
    private List<FormaPagamento> formaPagamentos;

    public Cliente() {
    }

    public Cliente(long id, String cpf, String nome, String sobrenome, String email, String senha, Endereco enderecoResidencial, String genero, String dataNascimento, String status, List<Cupom> cupons, List<Endereco> enderecosEntrega, List<FormaPagamento> formaPagamentos) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.enderecoResidencial = enderecoResidencial;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.cupons = cupons;
        this.enderecosEntrega = enderecosEntrega;
        this.formaPagamentos = formaPagamentos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Endereco getEnderecoResidencial() {
        return enderecoResidencial;
    }

    public void setEnderecoResidencial(Endereco enderecoResidencial) {
        this.enderecoResidencial = enderecoResidencial;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Cupom> getCupons() {
        return cupons;
    }

    public void setCupons(List<Cupom> cupons) {
        this.cupons = cupons;
    }

    public List<Endereco> getEnderecosEntrega() {
        return enderecosEntrega;
    }

    public void setEnderecosEntrega(List<Endereco> enderecosEntrega) {
        this.enderecosEntrega = enderecosEntrega;
    }

    public List<FormaPagamento> getFormaPagamentos() {
        return formaPagamentos;
    }

    public void setFormaPagamentos(List<FormaPagamento> formaPagamentos) {
        this.formaPagamentos = formaPagamentos;
    }
}