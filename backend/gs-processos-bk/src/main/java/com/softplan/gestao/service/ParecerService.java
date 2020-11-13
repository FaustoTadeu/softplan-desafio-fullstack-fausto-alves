package com.softplan.gestao.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softplan.gestao.model.Parecer;
import com.softplan.gestao.repository.ParecerRepository;
import com.softplan.gestao.service.exception.ObjectNotFoundException;

@Service
public class ParecerService {
	
	
	@Autowired
    private ParecerRepository parecerRepository;

	 
	public Parecer buscarParecerPorId(Integer idParecer) {
	    Optional<Parecer> obj = parecerRepository.findById(idParecer);
	    return obj.orElseThrow(() -> new ObjectNotFoundException(
	            "Objeto não encontrado! id: " + idParecer + ", Tipo: " + Parecer.class.getName()
	    ));
	}
	
	public List<Parecer> buscarTodosPareceres() {
        List<Parecer> obj = null;
        try {
            obj =  parecerRepository.getListaParecer();
        }catch (Exception e) {
            throw  new ObjectNotFoundException("Objetos do tipo " + Parecer.class.getName() + " não encontrados");
        }
        return obj;
    }
	
	public Parecer inserirEditarParecer(Parecer parecer) {
        return parecerRepository.save(parecer);
    }

    public Boolean alterarStatusParecer(Parecer parecer, String checked) {
        try{
        	parecer.setStatusParecer(checked);
            parecerRepository.save(parecer);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
