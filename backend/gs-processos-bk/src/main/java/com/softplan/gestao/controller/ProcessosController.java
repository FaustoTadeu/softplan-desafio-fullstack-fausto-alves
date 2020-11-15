package com.softplan.gestao.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.softplan.gestao.dto.PasswordDTO;
import com.softplan.gestao.dto.ProcessoRetornoDTO;
import com.softplan.gestao.dto.ProcessosListDTO;
import com.softplan.gestao.dto.ProcessosNewDTO;
import com.softplan.gestao.dto.StatusProcessoDTO;
import com.softplan.gestao.dto.UsuariosNewDTO;
import com.softplan.gestao.model.Processos;
import com.softplan.gestao.model.Usuarios;
import com.softplan.gestao.service.ProcessosService;

@RestController
@RequestMapping(value = "/processos")
public class ProcessosController {

	@Autowired
    private ProcessosService processosService;

	
	 @Transactional
	 //@PreAuthorize("hasAnyRole('TRIADOR')")
	 @RequestMapping(method = RequestMethod.GET)
	 public ResponseEntity<List<ProcessosListDTO>> findAllProcessos() {
	     List<Processos> listProcessos = processosService.buscarTodosProcessos();
	     List <ProcessosListDTO> processosListDto = listProcessos.stream().map(obj -> new ProcessosListDTO(obj)).collect(Collectors.toList());
	     return ResponseEntity.ok().body(processosListDto);
	 }
	 
	// @PreAuthorize("hasAnyRole('TRIADOR')")
	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(value ="/alterarStatusProcessos", method = RequestMethod.POST)
	 public ResponseEntity<Boolean> alterarStatusProcesso(@RequestBody StatusProcessoDTO statusProcesso) {
	     Boolean alterado =  processosService.alterarStatus(statusProcesso);
	     return ResponseEntity.ok().body(alterado);
	 }
	 
	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(method = RequestMethod.POST)
	 public ResponseEntity<ProcessoRetornoDTO> InsertProcessos(@Valid @RequestBody ProcessosNewDTO processoNewDto) throws JSONException {
		 ProcessoRetornoDTO retorno = new ProcessoRetornoDTO();
		 processoNewDto.setDataProcessos(new Date());
	     Processos processo = processosService.fromNewDTO(processoNewDto);
	     processo = processosService.inserirEditarProcessos(processo);
	     retorno.setNumeroProcesso(processo.getNumeroProcessos());
	     retorno.setTituloProcesso(processo.getTituloProcessos());
	     return ResponseEntity.ok().body(retorno);
	 }

	 @CrossOrigin(origins = "http://localhost:4200")
	 @RequestMapping(method = RequestMethod.PUT)
	 public ResponseEntity<ProcessoRetornoDTO> EditProcessos(@Valid @RequestBody ProcessosNewDTO processoEditDto) {
		 ProcessoRetornoDTO retorno = new ProcessoRetornoDTO();
		 processoEditDto.setDataProcessos(new Date());
	     Processos processo = processosService.fromDTO(processoEditDto);
	     processo = processosService.inserirEditarProcessos(processo);
	     retorno.setNumeroProcesso(processo.getNumeroProcessos());
	     retorno.setTituloProcesso(processo.getTituloProcessos());
	     return ResponseEntity.ok().body(retorno);
	 }
	 
}
