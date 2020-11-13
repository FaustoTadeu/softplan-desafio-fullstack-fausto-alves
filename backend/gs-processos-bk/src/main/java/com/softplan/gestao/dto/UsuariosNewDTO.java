package com.softplan.gestao.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.softplan.gestao.service.validation.UsuariosInsert;
import java.io.Serializable;


@UsuariosInsert
public class UsuariosNewDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer idUsuarios;

    @NotEmpty (message = "Preenchimento obrigatório")
    @Size (min=5, max=200,  message = "O nome do Usuarios deve ter entre 5 e 200 caracteres")
    private String nomeUsuarios;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email (message = "Email inválido")
    private String emailUsuarios;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String cpfUsuarios;

    private Integer perfil;

    private String statusUsuarios;

    public UsuariosNewDTO () {
    }


    public Integer getIdUsuarios() { return idUsuarios; }

    public void setIdUsuarios(Integer idUsuarios) { this.idUsuarios = idUsuarios; }

    public String getNomeUsuarios() { return nomeUsuarios; }

    public void setNomeUsuarios(String nomeUsuarios) { this.nomeUsuarios = nomeUsuarios; }

    public String getEmailUsuarios() { return emailUsuarios; }

    public void setEmailUsuarios(String emailUsuarios) { this.emailUsuarios = emailUsuarios; }

    public String getCpfUsuarios() { return cpfUsuarios; }

    public void setCpfUsuarios(String cpfUsuarios) { this.cpfUsuarios = cpfUsuarios; }

    public Integer getPerfil() { return perfil; }

    public void setPerfil(Integer perfil) { this.perfil = perfil; }

    public String getStatusUsuarios() { return statusUsuarios; }

    public void setStatusUsuarios(String statusUsuarios) { this.statusUsuarios = statusUsuarios; }
}