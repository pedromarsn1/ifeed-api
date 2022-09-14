package com.ifeed.ifeedapi.repository;

import com.ifeed.ifeedapi.model.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador,Long> {
}
