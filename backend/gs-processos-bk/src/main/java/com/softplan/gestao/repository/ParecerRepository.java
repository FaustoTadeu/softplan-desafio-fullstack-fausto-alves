package com.softplan.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.softplan.gestao.model.Parecer;


@Repository
public interface ParecerRepository extends JpaRepository<Parecer, Integer> {

}
