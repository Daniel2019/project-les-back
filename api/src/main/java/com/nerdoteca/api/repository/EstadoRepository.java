package com.nerdoteca.api.repository;

import com.nerdoteca.api.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("SELECT e FROM Estado e WHERE e.sigla = :estadoSigla")
    List<Estado> findEstadosBySigla(String estadoSigla);

}
