package com.nerdoteca.api.controller;

@RestController
@RequestMapping("formaPagamento")
public class FormaPagamentoController {


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public String listarFormaPagamento(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public String listarFormaPagamentoPorId(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarFormaPagamento(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public String atualizarFormaPagamento(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarFormaPagamento(){

    }
}
