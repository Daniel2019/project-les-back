package com.nerdoteca.api.repository;

import com.nerdoteca.api.domain.Endereco;
import com.nerdoteca.api.domain.FormaPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
    @Query("SELECT f FROM FormaPagamento f WHERE f.cliente.id = :clienteId")
    List<FormaPagamento> findByClienteId(Long clienteId);
}
