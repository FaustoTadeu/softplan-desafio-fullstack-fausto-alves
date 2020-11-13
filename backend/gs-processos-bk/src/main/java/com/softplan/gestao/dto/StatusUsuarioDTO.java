package  com.softplan.gestao.dto;

import java.io.Serializable;

public class StatusUsuarioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idUsuario;
    private String checked;

    public StatusUsuarioDTO() { }

    public StatusUsuarioDTO(Integer idUsuario, String checked) {
        this.idUsuario = idUsuario;
        this.checked = checked;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }
}
