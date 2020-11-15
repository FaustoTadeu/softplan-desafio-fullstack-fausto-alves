package com.softplan.gestao.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.softplan.gestao.dto.ProcessosNewDTO;
import com.softplan.gestao.dto.StatusProcessoDTO;
import com.softplan.gestao.model.Processos;
import com.softplan.gestao.repository.ProcessosRepository;
import com.softplan.gestao.service.exception.ObjectNotFoundException;

@Service
public class ProcessosService {

	@Autowired
    private ProcessosRepository processosRepository;

	 
	public Processos buscarProcessoPorId(Integer idProcesso) {
	    Optional<Processos> obj = processosRepository.findById(idProcesso);
	    return obj.orElseThrow(() -> new ObjectNotFoundException(
	            "Objeto não encontrado! id: " + idProcesso + ", Tipo: " + Processos.class.getName()
	    ));
	}
	
	public List<Processos> buscarTodosProcessos() {
        List<Processos> obj = null;
        try {
            obj =  processosRepository.getListaProcessos();
        }catch (Exception e) {
            throw  new ObjectNotFoundException("Objetos do tipo " + Processos.class.getName() + " não encontrados");
        }
        return obj;
    }
	
	public Processos inserirEditarProcessos(Processos processo) {
        return processosRepository.save(processo);
	}
	
    public Boolean alterarStatus(StatusProcessoDTO statusProcesso) {
	    Processos processos =  buscarProcessoPorId(statusProcesso.getIdProcessos());
	    try{
	        processos.setStatusProcessos(statusProcesso.getChecked());
	        processosRepository.save(processos);
	    } catch (Exception e) {
	        return false;
	    }
	    return true;
	}
    
    public Processos fromNewDTO (ProcessosNewDTO processoNewDto) {
        Processos processo = new Processos (null, processoNewDto.getNumeroProcessos(), processoNewDto.getTituloProcessos(), processoNewDto.getTextoProcessos(), processoNewDto.getDataProcessos(), "A");
        return processo;
    }
    
    public Processos fromDTO (ProcessosNewDTO processoEditDto) {
        return new Processos (processoEditDto.getIdProcessos(), processoEditDto.getNumeroProcessos(), processoEditDto.getTituloProcessos(), processoEditDto.getTextoProcessos(), processoEditDto.getDataProcessos(), processoEditDto.getStatusProcessos());
    }
}
