package com.nerdoteca.api.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "cupons")
public class Cupom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cup_id")
    private long id;

    @Column(name = "cup_valor")
    private float valor;

    @Column(name = "cup_data_validade")
    private String dataValidade;


    @Column(name = "cup_tipo")
    private String tipo;

    @Column(name = "cup_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "cup_cli_id")
    @JsonBackReference
    private Cliente cliente;

    public Cupom() {
    }

    public Cupom(long id, float valor, String dataValidade, String tipo, String status, Cliente cliente) {
        this.id = id;
        this.valor = valor;
        this.dataValidade = dataValidade;
        this.tipo = tipo;
        this.status = status;
        this.cliente = cliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Cupom{" +
                "id=" + id +
                ", valor=" + valor +
                ", dataValidade='" + dataValidade + '\'' +
                ", tipo='" + tipo + '\'' +
                ", status='" + status + '\'' +
                ", cliente=" + cliente +
                '}';
    }
}