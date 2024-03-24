package com.nerdoteca.api.repository;

import com.nerdoteca.api.domain.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomRepository extends JpaRepository<Cupom, Long> {
}
