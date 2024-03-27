package com.nerdoteca.api.controller;

import com.nerdoteca.api.domain.Cidade;
import com.nerdoteca.api.domain.Cliente;
import com.nerdoteca.api.domain.Endereco;
import com.nerdoteca.api.domain.Estado;
import com.nerdoteca.api.repository.CidadeRepository;
import com.nerdoteca.api.repository.ClienteRepository;
import com.nerdoteca.api.repository.EnderecoRepository;
import com.nerdoteca.api.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

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
    @GetMapping("/acessar/{cpf}")
    public List<Cliente> acessar(@PathVariable String cpf){
        List<Cliente> cliente = clienteRepository.acessar(cpf);
        return cliente;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/cadastrar")
    public String cadastrarCliente(@RequestBody Cliente cliente) {
        String message = "";
        try {
            cliente = clienteRepository.saveAndFlush(cliente);
            cliente.getEnderecosEntrega().get(0).setCliente(cliente);
            Endereco endereco = cliente.getEnderecosEntrega().get(0);

            List<Cidade> cidade = cidadeRepository.findCidadeByNome(endereco.getCidade().getNome(), endereco.getCidade().getEstado().getSigla());
            if(cidade.size() > 0){
                endereco.setCidade(cidade.get(0));
            }else{
                List<Estado> estado = estadoRepository.findEstadosBySigla(endereco.getCidade().getEstado().getSigla());
                endereco.getCidade().setEstado(estado.get(0));
                endereco.setCidade(cidadeRepository.saveAndFlush(endereco.getCidade()));
            }

            enderecoRepository.saveAndFlush(endereco);

            message = "Cliente cadastrado";
        }catch (Exception error){
            message = "Cliente nao cadastrado";
        }
        return message;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/atualizar/{id}")
    public Cliente atualizarCliente(@PathVariable long id, @RequestBody Cliente cliente) {

        cliente.getEnderecosEntrega().get(0).setCliente(cliente);
        Endereco endereco = cliente.getEnderecosEntrega().get(0);

        List<Cidade> cidade = cidadeRepository.findCidadeByNome(endereco.getCidade().getNome(), endereco.getCidade().getEstado().getSigla());
        if(cidade.size() > 0){
            endereco.setCidade(cidade.get(0));
        }else{
            List<Estado> estado = estadoRepository.findEstadosBySigla(endereco.getCidade().getEstado().getSigla());
            endereco.getCidade().setEstado(estado.get(0));
            endereco.setCidade(cidadeRepository.saveAndFlush(endereco.getCidade()));
        }

        enderecoRepository.saveAndFlush(endereco);

        cliente = clienteRepository.saveAndFlush(cliente);

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
