package com.softplan.gestao.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "parecer")
public class Parecer implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParecer;

    private String textoParecer;

    private String statusParecer;

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

	public String getStatusParecer() {
		return statusParecer;
	}

	public void setStatusParecer(String statusParecer) {
		this.statusParecer = statusParecer;
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
