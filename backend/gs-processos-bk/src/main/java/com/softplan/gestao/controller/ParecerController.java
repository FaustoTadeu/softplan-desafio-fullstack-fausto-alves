package com.softplan.gestao.controller;

import java.util.Date;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.softplan.gestao.dto.ParecerAtribuirDTO;
import com.softplan.gestao.dto.ParecerListDTO;
import com.softplan.gestao.model.Parecer;
import com.softplan.gestao.service.ParecerService;
import com.softplan.gestao.service.ProcessosService;
import com.softplan.gestao.service.UsuariosService;

@RestController
@RequestMapping(value = "/parecer")
public class ParecerController {
	
	
	@Autowired
    private ParecerService parecerService;
	
	@Autowired
    private UsuariosService usuariosService;
	
	@Autowired
    private ProcessosService processosService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value ="/atribuirProcessoUsuario", method = RequestMethod.POST)
	public ResponseEntity<ParecerListDTO> atribuirProcessoUsuario(@Valid @RequestBody ParecerAtribuirDTO parecerAtributoDto) throws JSONException {
		ParecerListDTO retorno = new ParecerListDTO();
	    Parecer parecer = parecerService.fromParecerAtributoDTO(parecerAtributoDto);
	    parecer.setDtCadastroParecer(new Date());
	    parecer = parecerService.inserirEditarParecer(parecer);
	    retorno.setUsuarioParecer(usuariosService.buscarUsuariosPorId(parecer.getUsuario().getIdUsuarios()));
	    retorno.setProcessoParecer(processosService.buscarProcessoPorId(parecer.getProcesso().getIdProcessos()));
	    return ResponseEntity.ok().body(retorno);
	 }

}
