package com.softplan.gestao.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.softplan.gestao.dto.PerfilDTO;
import com.softplan.gestao.dto.StatusUsuarioDTO;
import com.softplan.gestao.dto.UsuariosDTO;
import com.softplan.gestao.dto.UsuariosNewDTO;
import com.softplan.gestao.enums.PerfilUsuario;
import com.softplan.gestao.model.Usuarios;
import com.softplan.gestao.repository.UsuariosRepository;
import com.softplan.gestao.security.UserSS;
import com.softplan.gestao.service.exception.AuthorizationException;
import com.softplan.gestao.service.exception.ObjectNotFoundException;

@Service
public class UsuariosService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private UsuariosRepository usuariosRepository;


    public Usuarios buscarUsuariosPorId(Integer idUsuario) {

        UserSS user = UserService.authenticated();
        if(user == null || !user.hasRole(PerfilUsuario.ADMIN) && !idUsuario.equals(user.getId())){
            throw new AuthorizationException("Acesso Negado!");
        }

        Optional<Usuarios> obj = usuariosRepository.findById(idUsuario);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! id: " + idUsuario + ", Tipo: " + Usuarios.class.getName()
        ));
    }

    public List<Usuarios> buscarTodosUsuarios() {
        List<Usuarios> obj = null;
        try {
            obj =  usuariosRepository.getListaUsuarios();
        }catch (Exception e) {
            throw  new ObjectNotFoundException("Objetos do tipo " + Usuarios.class.getName() + " não encontrados");
        }
        return obj;
    }

    public UsuariosDTO buscarUsuariosPorEmail (String email) {
        UserSS user = UserService.authenticated();
        if(user == null || !user.hasRole(PerfilUsuario.ADMIN) && !email.equals(user.getUsername())) {
            throw new AuthorizationException("Acesso negado");
        }
        Usuarios usuarios = usuariosRepository.findByEmail(email);
        UsuariosDTO usuariosDto = new UsuariosDTO(usuarios);
        if(usuarios == null) {
            throw  new ObjectNotFoundException("Objeto não encontrado! Email: " + email + " Tipo: " + Usuarios.class);
        }
        return usuariosDto;
    }

    public PerfilDTO buscarPerfilUsuarioLogado () {
        UserSS user = UserService.authenticated();
        PerfilDTO perfil = new PerfilDTO();
        if(user.hasRole(PerfilUsuario.ADMIN)) {
            perfil.setCodPerfil(PerfilUsuario.ADMIN.getCod());
            perfil.setNomePerfil(PerfilUsuario.ADMIN.getNome());
        } else {
            perfil.setCodPerfil(PerfilUsuario.ATENDENTE.getCod());
            perfil.setNomePerfil(PerfilUsuario.ATENDENTE.getNome());
        }
        return perfil;
    }

    public Usuarios inserirEditarUsuarios(Usuarios usuario) {
        if (usuario.getIdUsuarios() != null) {
            Usuarios editUsuario = buscarUsuariosPorId(usuario.getIdUsuarios());
            editUsuario.setNomeUsuarios(usuario.getNomeUsuarios());
            editUsuario.setEmailUsuarios(usuario.getEmailUsuarios());
            editUsuario.setPerfil(PerfilUsuario.toEnum(usuario.getPerfis().iterator().next().getCod()));
            return usuariosRepository.save(editUsuario);
        } else {
            return usuariosRepository.save(usuario);
        }
    }

    public Boolean alterarStatus(StatusUsuarioDTO statusUsuario) {
        Usuarios usuario =  buscarUsuariosPorId(statusUsuario.getIdUsuario());
        try{
            usuario.setStatusUsuarios(statusUsuario.getChecked());
            usuariosRepository.save(usuario);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Usuarios fromDTO (UsuariosNewDTO usuarioEditDto, String senha) {
        Set<Integer> perfis = new HashSet<>();
        perfis.add(usuarioEditDto.getPerfil());
        return new Usuarios (usuarioEditDto.getIdUsuarios(), usuarioEditDto.getCpfUsuarios(), usuarioEditDto.getNomeUsuarios(), usuarioEditDto.getEmailUsuarios(), pe.encode(senha),  perfis);
    }

    public Usuarios fromNewDTO (UsuariosNewDTO usuarioNewDto, String senha) {
        Set<Integer> perfis = new HashSet<>();
        perfis.add(usuarioNewDto.getPerfil());
        Usuarios usuario = new Usuarios (null, usuarioNewDto.getNomeUsuarios(), usuarioNewDto.getEmailUsuarios(), usuarioNewDto.getCpfUsuarios(), "A", new Date(), pe.encode(senha), perfis);
        return usuario;
    }
}
