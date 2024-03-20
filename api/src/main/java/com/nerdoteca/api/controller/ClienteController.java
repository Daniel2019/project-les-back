package com.nerdoteca.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public String listarClientes(){
        return "Teste";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public String listarClientePorId(@PathVariable long id){
        return "Teste 2";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarCliente(@RequestBody String cliente) {
        return "Teste 3";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable long id, @RequestBody String cliente) {
        return "Teste 3";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarCliente(@PathVariable long id){
        return "Teste 4";
    }

}
