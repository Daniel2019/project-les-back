package com.nerdoteca.api.controller;

import com.nerdoteca.api.domain.FormaPagamento;
import com.nerdoteca.api.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("formaPagamentos")
public class FormaPagamentoController {

    @Autowired
    FormaPagamentoRepository formaPagamentoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public List<FormaPagamento> listarFormaPagamento(){
        List<FormaPagamento> formaPagamentos = formaPagamentoRepository.findAll();
        return formaPagamentos;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public Optional<FormaPagamento> listarFormaPagamentoPorId(@PathVariable long id){
        Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(id);
        return formaPagamento;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarFormaPagamento(@RequestBody FormaPagamento formaPagamento){
        String message = "";

        try {
            formaPagamentoRepository.saveAndFlush(formaPagamento);
            message = "Forma Pagamento cadastrado com sucesso!";
        }catch (Exception error){
            message = "Forma Pagamento nao cadastrado!";
        }

        return message;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public FormaPagamento atualizarFormaPagamento(@PathVariable long id, @RequestBody FormaPagamento formaPagamento){
        formaPagamentoRepository.findById(id);
        formaPagamentoRepository.saveAndFlush(formaPagamento);
        return formaPagamento;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarFormaPagamento(@PathVariable long id){
        String message = "";
        try{
            message = "Forma de Pagamento deletado com sucesso";
        }catch (Exception error){
            message = "Forma de Pagamento nao deletado";
        }
        return message;
    }
}
