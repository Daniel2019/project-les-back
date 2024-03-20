package com.nerdoteca.api.controller;

@RestController
@RequestMapping("endereco")
public class EnderecoContoller {

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public String listarEnderecos(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public String listarEnderecoPorId(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarEndereco(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public String atualizarEndereco(){

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarEndereco(){

    }
}
