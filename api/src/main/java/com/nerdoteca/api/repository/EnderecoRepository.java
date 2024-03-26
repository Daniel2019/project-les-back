package com.nerdoteca.api.repository;

import com.nerdoteca.api.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT e FROM Endereco e WHERE e.cliente.id = :clienteId")
    List<Endereco> findByClienteId(Long clienteId);

}
