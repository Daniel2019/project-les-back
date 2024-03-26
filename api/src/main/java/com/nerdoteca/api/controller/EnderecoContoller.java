package com.nerdoteca.api.controller;

import com.nerdoteca.api.domain.Cliente;
import com.nerdoteca.api.domain.Endereco;
import com.nerdoteca.api.repository.ClienteRepository;
import com.nerdoteca.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("enderecos")
public class EnderecoContoller {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public List<Endereco> listarEnderecos(){
        List<Endereco> meusEnderecos = enderecoRepository.findAll();
        return meusEnderecos;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public Optional<Endereco> listarEnderecoPorId(@PathVariable long id){
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        return endereco;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/cliente/{id}")
    public List<Endereco> listarEnderecosPorIdDoCliente(@PathVariable long id){
        List<Endereco> meusEnderecos = enderecoRepository.findByClienteId(id);
        return  meusEnderecos;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarEndereco(@RequestBody Endereco endereco){
        String message = "";

        try {
            Optional<Cliente> clienteExiste = clienteRepository.findById(endereco.getCliente().getId());
            endereco.setCliente(clienteExiste.get());
            enderecoRepository.saveAndFlush(endereco);
            message = "Endereco cadastrado com sucesso!";
        }catch (Exception error){
            message = "Endereco nao cadastrado!";
        }

        return message;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public Endereco atualizarEndereco(@PathVariable long id, @RequestBody Endereco endereco){
        enderecoRepository.findById(id);
        Optional<Cliente> clienteExiste = clienteRepository.findById(endereco.getCliente().getId());
        endereco.setCliente(clienteExiste.get());
        enderecoRepository.saveAndFlush(endereco);
        return endereco;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarEndereco(@PathVariable long id){
        String message = "";

        try{
            enderecoRepository.deleteById(id);
            message = "Enderecos deletado com sucesso";
        }catch (Exception error){
            message = "Enderecos nao deletado";
        }

        return message;
    }
}
