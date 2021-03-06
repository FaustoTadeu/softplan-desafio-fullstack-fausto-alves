package com.softplan.gestao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "parecer")
public class Parecer implements Serializable {

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
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_usuario_parecer")
    private Usuarios usuario;
    
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="id_processo_parecer")
    private Processos processo;

	public Parecer() {
		super();
	}
	
	

	public Parecer(Integer idUsuario, Integer idProcesso) {
		super();
		
		this.usuario = new Usuarios();
		this.usuario.setIdUsuarios(idUsuario);
		this.processo = new Processos();
		this.processo.setIdProcessos(idProcesso);
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
