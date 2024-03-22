package com.nerdoteca.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("usuarios")
public class UsuarioController {
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public String listarUsuarios(){
        return "Teste";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public String listarUsuarioPorId(@PathVariable long id){
        return "Teste 2";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestBody String usuario) {
        return "Teste 3";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public String atualizarUsuario(@PathVariable long id, @RequestBody String usuario) {
        return "Teste 3";
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarUsuario(@PathVariable long id){
        return "Teste 4";
    }

}
