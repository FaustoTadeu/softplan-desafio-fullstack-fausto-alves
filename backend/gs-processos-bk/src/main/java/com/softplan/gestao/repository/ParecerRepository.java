package com.softplan.gestao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.softplan.gestao.model.Parecer;


@Repository
public interface ParecerRepository extends JpaRepository<Parecer, Integer> {

	
	 @Transactional(readOnly = true)
	 @Query("SELECT p FROM parecer p ORDER BY p.dtCadastroParecer DESC")
	 public List<Parecer> getListaParecer();
}
