package com.softplan.gestao.dto;

public class PasswordDTO {

    String pass;
    String loginUsuario;

    public PasswordDTO() {}

    public PasswordDTO(String pass, String loginUsuario) {
        this.pass = pass;
        this.loginUsuario = loginUsuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
}
