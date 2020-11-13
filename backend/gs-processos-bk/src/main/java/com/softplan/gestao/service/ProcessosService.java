package com.softplan.gestao.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
}
