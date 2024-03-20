package com.nerdoteca.api.domain;

import java.util.ArrayList;

public class Cliente extends Usuario {

    private Endereco enderecoResidencial;
    private ArrayList<Cupons> cupons = new ArrayList<Cupons>();
    private ArrayList<Endereco> enderecosEntrega = new ArrayList<Endereco>();
    private ArrayList<FormaPagamento> formaPagamentos = new ArrayList<FormaPagamento>();


}