package com.softplan.gestao.dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.softplan.gestao.model.Processos;
import com.softplan.gestao.model.Usuarios;

public class ParecerNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParecer;

    @NotEmpty (message = "O texto do parecer é de preenchimento obrigatório")
    @Size (min=5, max=2000,  message = "O texto do parecer deve ter entre 5 e 2000 caracteres")
    private String textoParecer;

    @NotEmpty (message = "O status do parecer é de preenchimento obrigatório")
    private String decisaoParecer;

    @NotEmpty (message = "A data de cadastro do parecer é de preenchimento obrigatório")
    private Date dtCadastroParecer;
    
    @NotEmpty (message = "A data de cadastro do parecer é de preenchimento obrigatório")
    private Usuarios usuario;
    
    @NotEmpty (message = "A data de cadastro do parecer é de preenchimento obrigatório")
    private Processos processo;

	
    public ParecerNewDTO() {
		super();
	}


	public ParecerNewDTO(Integer idParecer, String textoParecer, String decisaoParecer,  Date dtCadastroParecer, Usuarios usuario, Processos processo) {
		super();
		this.idParecer = idParecer;
		this.textoParecer = textoParecer;
		this.decisaoParecer = decisaoParecer;
		this.dtCadastroParecer = dtCadastroParecer;
		this.usuario = usuario;
		this.processo = processo;
	}


	public Integer getIdParecer() {
		return idParecer;
	}


	public void setIdParecer(Integer idParecer) {
		this.idParecer = idParecer;
	}


	public String getTextoParecer() {
		return textoParecer;
	}


	public void setTextoParecer(String textoParecer) {
		this.textoParecer = textoParecer;
	}


	public String getDecisaoParecer() {
		return decisaoParecer;
	}


	public void setDecisaoParecer(String decisaoParecer) {
		this.decisaoParecer = decisaoParecer;
	}


	public Date getDtCadastroParecer() {
		return dtCadastroParecer;
	}


	public void setDtCadastroParecer(Date dtCadastroParecer) {
		this.dtCadastroParecer = dtCadastroParecer;
	}


	public Usuarios getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}


	public Processos getProcesso() {
		return processo;
	}


	public void setProcesso(Processos processo) {
		this.processo = processo;
	}
}
