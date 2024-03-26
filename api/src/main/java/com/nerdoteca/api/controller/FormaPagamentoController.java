package com.nerdoteca.api.controller;

import com.nerdoteca.api.domain.Cliente;
import com.nerdoteca.api.domain.FormaPagamento;
import com.nerdoteca.api.repository.ClienteRepository;
import com.nerdoteca.api.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("formaPagamentos")
public class FormaPagamentoController {

    @Autowired
    ClienteRepository clienteRepository;

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
    @GetMapping("/listar/cliente/{id}")
    public List<FormaPagamento> listarFormaPagamentoPorIdDoCliente(@PathVariable long id){
        List<FormaPagamento> formaPagamentos = formaPagamentoRepository.findByClienteId(id);
        return  formaPagamentos;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarFormaPagamento(@RequestBody FormaPagamento formaPagamento){
        String message = "";

        try {
            Optional<Cliente> clienteExiste = clienteRepository.findById(formaPagamento.getCliente().getId());
            formaPagamento.setCliente(clienteExiste.get());
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
        Optional<Cliente> clienteExiste = clienteRepository.findById(formaPagamento.getCliente().getId());
        formaPagamento.setCliente(clienteExiste.get());
        formaPagamentoRepository.saveAndFlush(formaPagamento);
        return formaPagamento;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarFormaPagamento(@PathVariable long id){
        String message = "";
        try{
            formaPagamentoRepository.deleteById(id);
            message = "Forma de Pagamento deletado com sucesso";
        }catch (Exception error){
            message = "Forma de Pagamento nao deletado";
        }
        return message;
    }
}
