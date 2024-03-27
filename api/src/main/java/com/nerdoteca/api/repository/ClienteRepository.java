package com.nerdoteca.api.repository;

import com.nerdoteca.api.domain.Cliente;
import com.nerdoteca.api.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    List<Cliente> acessar(String cpf);


}
