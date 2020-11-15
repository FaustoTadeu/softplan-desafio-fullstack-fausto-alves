package com.softplan.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.softplan.gestao.model.Processos;

@Repository
public interface ProcessosRepository extends JpaRepository<Processos, Integer> {

	
	@Transactional(readOnly = true)
	 @Query("SELECT p FROM processos p WHERE p.statusProcessos <> 'E' ORDER BY p.dtCadastroProcessos DESC")
	 public List<Processos> getListaProcessos();
}
