package com.softplan.gestao.dto;

import java.io.Serializable;

public class CredenciaisDTO  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String emailUsuarios;
    private String senhaUsuarios;

    public CredenciaisDTO() {

    }

    public CredenciaisDTO(String emailUsuarios, String senhaUsuarios) {
        this.emailUsuarios = emailUsuarios;
        this.senhaUsuarios = senhaUsuarios;
    }

    public String getEmailUsuarios() {
        return emailUsuarios;
    }

    public void setEmailUsuarios(String emailUsuarios) {
        this.emailUsuarios = emailUsuarios;
    }

    public String getSenhaUsuarios() {
        return senhaUsuarios;
    }

    public void setSenhaUsuarios(String senhaUsuarios) {
        this.senhaUsuarios = senhaUsuarios;
    }
}