package  com.softplan.gestao.dto;

public class PerfilDTO {

    private Integer codPerfil;
    private String nomePerfil;


    public PerfilDTO() {
    }

    public PerfilDTO(Integer codPerfil, String nomePerfil) {
        this.codPerfil = codPerfil;
        this.nomePerfil = nomePerfil;
    }

    public Integer getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(Integer codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getNomePerfil() {
        return nomePerfil;
    }

    public void setNomePerfil(String nomePerfil) {
        this.nomePerfil = nomePerfil;
    }
}
