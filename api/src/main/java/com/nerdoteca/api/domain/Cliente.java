package com.nerdoteca.api.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
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

    @Column(name = "cli_genero")
    private String genero;

    @Column(name = "cli_data_nascimento")
    private String dataNascimento;

    @Column(name = "cli_status")
    private String status;

    @Column(name = "cli_tipo_contato")
    private String tipoContato;

    @Column(name = "cli_ddd")
    private int ddd;

    @Column(name = "cli_numero")
    private int numeroTelefone;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Cupom> cupons;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<Endereco> enderecosEntrega;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<FormaPagamento> formaPagamentos;

    public Cliente() {
    }

    public Cliente(long id, String cpf, String nome, String sobrenome, String email, String senha, String genero, String dataNascimento, String status, String tipoContato, int ddd, int numeroTelefone, List<Cupom> cupons, List<Endereco> enderecosEntrega, List<FormaPagamento> formaPagamentos) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.status = status;
        this.tipoContato = tipoContato;
        this.ddd = ddd;
        this.numeroTelefone = numeroTelefone;
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

    public String getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(int numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public List<Cupom> getCupons() {
        return cupons;
    }

    public void setCupons(List<Cupom> cupons) {
        this.cupons = cupons;
    }

    public void adicionarCupom(Cupom cupom) {
        this.cupons.add(cupom);
        cupom.setCliente(this);
    }

    public void removerCupom(Cupom cupom) {
        this.cupons.remove(cupom);
        cupom.setCliente(null);
    }

    public List<Endereco> getEnderecosEntrega() {
        return enderecosEntrega;
    }

    public void setEnderecosEntrega(List<Endereco> enderecosEntrega) {
        this.enderecosEntrega = enderecosEntrega;
    }

    public void adicionarEndereco(Endereco endereco) {
        this.enderecosEntrega.add(endereco);
        endereco.setCliente(this);
    }

    public void removerEndereco(Endereco endereco) {
        this.enderecosEntrega.remove(endereco);
        endereco.setCliente(null);
    }

    public List<FormaPagamento> getFormaPagamentos() {
        return formaPagamentos;
    }

    public void setFormaPagamentos(List<FormaPagamento> formaPagamentos) {
        this.formaPagamentos = formaPagamentos;
    }

    public void adicionarEndereco(FormaPagamento formaPagamento) {
        this.formaPagamentos.add(formaPagamento);
        formaPagamento.setCliente(this);
    }

    public void removerFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamentos.remove(formaPagamento);
        formaPagamento.setCliente(null);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", genero='" + genero + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", status='" + status + '\'' +
                ", tipoContato='" + tipoContato + '\'' +
                ", ddd=" + ddd +
                ", numeroTelefone=" + numeroTelefone +
                ", cupons=" + cupons +
                ", enderecosEntrega=" + enderecosEntrega +
                ", formaPagamentos=" + formaPagamentos +
                '}';
    }
}