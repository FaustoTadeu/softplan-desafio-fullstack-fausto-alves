package com.softplan.gestao.dto;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.softplan.gestao.model.Usuarios;
import com.softplan.gestao.service.validation.UsuariosUpdate;

@UsuariosUpdate
public class UsuariosDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuarios;

    @NotEmpty (message = "Preenchimento obrigatório")
    @Size (min=5, max=200,  message = "O nome do Usuarios deve ter entre 5 e 200 caracteres")
    private String nomeUsuarios;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email (message = "Email inválido")
    private String emailUsuarios;

    public UsuariosDTO () {}

    public UsuariosDTO (Usuarios Usuarios) {
        this.idUsuarios = Usuarios.getIdUsuarios();
        this.nomeUsuarios = Usuarios.getNomeUsuarios();
        this.emailUsuarios = Usuarios.getEmailUsuarios();
    }

    public Integer getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Integer idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    public String getNomeUsuarios() {
        return nomeUsuarios;
    }

    public void setNomeUsuarios(String nomeUsuarios) {
        this.nomeUsuarios = nomeUsuarios;
    }

    public String getEmailUsuarios() {
        return emailUsuarios;
    }

    public void setEmailUsuarios(String emailUsuarios) {
        this.emailUsuarios = emailUsuarios;
    }
}