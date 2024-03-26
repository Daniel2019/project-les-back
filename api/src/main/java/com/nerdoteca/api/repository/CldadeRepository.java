package com.nerdoteca.api.repository;

import com.nerdoteca.api.domain.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CldadeRepository extends JpaRepository<Cidade, Long> {
}
