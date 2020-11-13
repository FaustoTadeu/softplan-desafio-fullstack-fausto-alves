package com.softplan.gestao.service;

import com.softplan.gestao.model.Usuarios;
import com.softplan.gestao.repository.UsuariosRepository;
import com.softplan.gestao.security.UserSS;
import com.softplan.gestao.service.exception.UserInactiveException;
import com.softplan.gestao.service.exception.UserRemovedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String emailUsuarios) throws UsernameNotFoundException {
        Usuarios usuario = usuariosRepository.findByEmail(emailUsuarios);
        if(usuario == null) {
            throw new UsernameNotFoundException("NE"); // Usuário não encontrado
        } else if (usuario.getStatusUsuarios().equals("E")) {
            throw new UserRemovedException("E"); // Usuário Excluído
        } else if (usuario.getStatusUsuarios().equals("I")) {
            throw new UserInactiveException("I"); // Usuário Inativo
        }
        return new UserSS(usuario.getIdUsuarios(), usuario.getEmailUsuarios(), usuario.getSenhaUsuarios(), usuario.getPerfis());
    }
}
