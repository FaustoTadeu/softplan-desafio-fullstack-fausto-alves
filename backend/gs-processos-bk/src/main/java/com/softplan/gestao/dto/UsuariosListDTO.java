package  com.softplan.gestao.dto;

import java.io.Serializable;

import com.softplan.gestao.model.Usuarios;


public class UsuariosListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuarios;

    private String nomeUsuarios;

    private String emailUsuarios;

    private String cpfUsuarios;

    private Integer perfil;

    private String statusUsuarios;

    public UsuariosListDTO() {
    }

    public UsuariosListDTO (Usuarios usuarios) {
        this.idUsuarios = usuarios.getIdUsuarios();
        this.nomeUsuarios = usuarios.getNomeUsuarios();
        this.emailUsuarios = usuarios.getEmailUsuarios();
        this.cpfUsuarios = usuarios.getCpfUsuarios();
        this.perfil = usuarios.getPerfis().iterator().next().getCod();
        this.statusUsuarios = usuarios.getStatusUsuarios();
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

    public String getEmailUsuarios() {
        return emailUsuarios;
    }

    public String getCpfUsuarios() {
        return cpfUsuarios;
    }


    public Integer getPerfil() { return perfil; }

    public String getStatusUsuarios() { return statusUsuarios; }

    public void setStatusUsuarios(String statusUsuarios) { this.statusUsuarios = statusUsuarios; }
}
