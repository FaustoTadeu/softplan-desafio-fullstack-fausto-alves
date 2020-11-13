package com.softplan.gestao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.softplan.gestao.dto.PasswordDTO;
import com.softplan.gestao.dto.PerfilDTO;
import com.softplan.gestao.dto.StatusUsuarioDTO;
import com.softplan.gestao.dto.UsuariosDTO;
import com.softplan.gestao.dto.UsuariosListDTO;
import com.softplan.gestao.dto.UsuariosNewDTO;
import com.softplan.gestao.model.Usuarios;
import com.softplan.gestao.service.AuthService;
import com.softplan.gestao.service.UsuariosService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private AuthService authService;

    @RequestMapping(value ="/{idUsuarios}", method = RequestMethod.GET)
    public ResponseEntity<Usuarios> findUsuariosById(@PathVariable Integer idUsuarios) {
        Usuarios obj = usuariosService.buscarUsuariosPorId(idUsuarios);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value ="/perfil", method = RequestMethod.GET)
    public ResponseEntity<PerfilDTO> findPerfilUsuarioLogado() {
        return ResponseEntity.ok().body(usuariosService.buscarPerfilUsuarioLogado());
    }

    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UsuariosListDTO>> findAllUsuarios() {
        List<Usuarios> listUsuarios = usuariosService.buscarTodosUsuarios();
        List <UsuariosListDTO> usuariosListDto = listUsuarios.stream().map(obj -> new UsuariosListDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(usuariosListDto);
    }

    @Transactional
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public ResponseEntity<UsuariosDTO> findByEmail(@RequestParam(value = "value")String email) {
        UsuariosDTO obj = usuariosService.buscarUsuariosPorEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PasswordDTO> InsertUsuarios(@Valid @RequestBody UsuariosNewDTO usuarioNewDto) throws JSONException {
        PasswordDTO retorno = new PasswordDTO();
        String senha = authService.newPassword();
        Usuarios usuario = usuariosService.fromNewDTO(usuarioNewDto, senha);
        usuario = usuariosService.inserirEditarUsuarios(usuario);
        retorno.setPass(senha);
        retorno.setLoginUsuario(usuario.getEmailUsuarios());
        return ResponseEntity.ok().body(retorno);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<PasswordDTO> EditUsuarios(@Valid @RequestBody UsuariosNewDTO usuarioEditDto) {
        PasswordDTO retorno = new PasswordDTO();
        String senha = authService.newPassword();
        Usuarios usuario = usuariosService.fromDTO(usuarioEditDto, senha);
        usuario = usuariosService.inserirEditarUsuarios(usuario);
        retorno.setPass(senha);
        retorno.setLoginUsuario(usuario.getEmailUsuarios());
        return ResponseEntity.ok().body(retorno);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value ="/alterarStatusUsuario", method = RequestMethod.POST)
    public ResponseEntity<Boolean> alterarStatusUsuario(@RequestBody StatusUsuarioDTO statusUsuario) {
       Boolean alterado =  usuariosService.alterarStatus(statusUsuario);
        return ResponseEntity.ok().body(alterado);
    }

}

