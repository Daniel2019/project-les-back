package com.nerdoteca.api.repository;

import com.nerdoteca.api.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    @Query("SELECT c FROM Cidade c JOIN Estado e on e.id = c.estado.id WHERE c.nome = :cidadeNome AND e.sigla = :siglaEstado")
    List<Cidade> findCidadeByNome(String cidadeNome, String siglaEstado);

}
