package com.softplan.gestao.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softplan.gestao.dto.ParecerAtribuirDTO;
import com.softplan.gestao.dto.ParecerListDTO;
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
	
	public List<Parecer> buscarParecerPorIdUsuario(Integer idUsuario) {
	    List<Parecer> obj = null;
	    try {
	        obj =  parecerRepository.buscarListaParecerPorUsuario(idUsuario);
	    }catch (Exception e) {
	        throw  new ObjectNotFoundException("Objetos do tipo " + Parecer.class.getName() + " não encontrados");
	    }
	    return obj;
	}
	
	public List<Parecer> buscarTodosPareceres() {
        List<Parecer> obj = null;
        try {
            obj =  parecerRepository.buscarListaParecer();
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
	
	public List<ParecerListDTO> fromParecer (List<Parecer> parecerList) {
		List<ParecerListDTO> listaConverted = new ArrayList<ParecerListDTO>();
		for(Parecer pr: parecerList) {
			ParecerListDTO parecerConverted = new ParecerListDTO();
			parecerConverted.setIdParecer(pr.getIdParecer());
			parecerConverted.setNumeroProcesso(pr.getProcesso().getNumeroProcessos());
			parecerConverted.setTituloProcesso(pr.getProcesso().getTituloProcessos());
			parecerConverted.setNomeUsuario(pr.getUsuario().getNomeUsuarios());
			parecerConverted.setTextoParecer(pr.getTextoParecer());
			parecerConverted.setDecisaoParecer(pr.getDecisaoParecer());
			parecerConverted.setDataParecer(pr.getDtCadastroParecer());
			listaConverted.add(parecerConverted);
		}
		
		return listaConverted;
	}
	
}
