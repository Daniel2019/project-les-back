package com.nerdoteca.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("formaPagamentos")
public class FormaPagamentoController {


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public String listarFormaPagamento(){
        return "Teste 1";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public String listarFormaPagamentoPorId(){
        return "Teste 1";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarFormaPagamento(){
        return "Teste 1";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public String atualizarFormaPagamento(){
        return "Teste 1";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarFormaPagamento(){
        return "Teste 1";
    }
}
