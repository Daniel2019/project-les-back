package com.nerdoteca.api.controller;

import com.nerdoteca.api.domain.Cupom;
import com.nerdoteca.api.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cupons")
public class CupomController {

    @Autowired
    CupomRepository cupomRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar")
    public List<Cupom> listarCupons(){
        List<Cupom> cupons = cupomRepository.findAll();
        return cupons;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/listar/{id}")
    public Optional<Cupom> listarCupomPorId(@PathVariable long id){
        Optional<Cupom> cupom = cupomRepository.findById(id);
        return cupom;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarCupom(@RequestBody Cupom cupom){
        String message = "";

        try{
            cupomRepository.saveAndFlush(cupom);
            message = "Cupom cadastrado!";
        }catch (Exception error){
            message = "Cupom nao cadastrado";
        }

        return message;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public Cupom atualizarCupom(@PathVariable long id,  @RequestBody Cupom cupom){
        cupomRepository.findById(id);
        cupomRepository.saveAndFlush(cupom);
        return cupom;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/deletar/{id}")
    public String deletarCupom (@PathVariable long id){

        String message = "";

        try{
            cupomRepository.deleteById(id);
            message = "Cupom deletado com sucesso!";
        }catch (Exception error){
            message = "Cupom nao deletado!";
        }

        return message;
    }

}