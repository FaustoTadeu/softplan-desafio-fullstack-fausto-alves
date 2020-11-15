package com.softplan.gestao.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softplan.gestao.dto.ParecerAtribuirDTO;
import com.softplan.gestao.dto.ProcessosNewDTO;
import com.softplan.gestao.model.Parecer;
import com.softplan.gestao.model.Processos;
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
	
	public Parecer fromParecerAtributoDTO (ParecerAtribuirDTO parecerAtributoDto) {
        Parecer parecer = new Parecer (parecerAtributoDto.getIdUsuario(), parecerAtributoDto.getIdProcesso());
        return parecer;
    }
	
}
