package com.nerdoteca.api.controller;

import com.nerdoteca.api.domain.Cliente;
import com.nerdoteca.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public List<Cliente> listarClientes(){
        List<Cliente> clientes= clienteRepository.findAll();
        return clientes;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public Optional<Cliente> listarClientePorId(@PathVariable long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarCliente(@RequestBody Cliente cliente) {
        String message = "";

        try {
            clienteRepository.saveAndFlush(cliente);
        }catch (Exception error){
            message = "Cliente nao cadastrado";
        }
        return message;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public Cliente atualizarCliente(@PathVariable long id, @RequestBody Cliente cliente) {
        clienteRepository.findById(id);
        clienteRepository.saveAndFlush(cliente);
        return cliente;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable long id){
        String message = "";

        try {
            message = "Cliente deletado com sucesso!";
        } catch (Exception error){
            message = "Cliente nao deletado!";
        }
        return message;
    }

}
