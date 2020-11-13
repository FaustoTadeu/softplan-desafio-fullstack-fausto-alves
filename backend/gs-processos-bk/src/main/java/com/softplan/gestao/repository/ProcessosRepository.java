package com.softplan.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softplan.gestao.model.Processos;

@Repository
public interface ProcessosRepository extends JpaRepository<Processos, Integer> {

}
