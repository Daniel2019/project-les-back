package com.nerdoteca.api.controller;

import com.nerdoteca.api.dao.EnderecoDAO;
import com.nerdoteca.api.domain.Cidade;
import com.nerdoteca.api.domain.Endereco;
import com.nerdoteca.api.domain.Estado;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("enderecos")
public class EnderecoContoller {

    private EnderecoDAO enderecoDAO;

    public EnderecoContoller() {
        this.enderecoDAO = new EnderecoDAO();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public ArrayList<Endereco> listarEnderecos(){
        ArrayList<Endereco> meusEnderecos = new ArrayList<Endereco>();

        Estado estado = new Estado(01, "São Paulo", "SP", "Brasil");
        Cidade cidade = new Cidade(01, "Poá", estado);

        Endereco enderecoResidencial = new Endereco();
        enderecoResidencial.setId(01);
        enderecoResidencial.setNomeEndereco("Endereco residencial");
        enderecoResidencial.setTipoEndereco("RESIDENCIAL");
        enderecoResidencial.setCep("08555140");
        enderecoResidencial.setTipoLogradouro("Rua");
        enderecoResidencial.setLogradouro("Sapucaí");
        enderecoResidencial.setNumero(104);
        enderecoResidencial.setBairro("Jardim Santa Luiza");
        enderecoResidencial.setTipoResidencia("Casa");
        enderecoResidencial.setCidade(cidade);
        enderecoResidencial.setObservacoes("Minha casa");

        meusEnderecos.add(enderecoResidencial);

        return meusEnderecos;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public Endereco listarEnderecoPorId(){
        Endereco endereco = new Endereco();
        endereco.setId(01);

        try {
            this.enderecoDAO.consultarPorId(endereco);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return endereco;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarEndereco(){
        return "Teste 1";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public String atualizarEndereco(){
        return "Teste 1";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarEndereco(){
        return "Teste 1";
    }
}
