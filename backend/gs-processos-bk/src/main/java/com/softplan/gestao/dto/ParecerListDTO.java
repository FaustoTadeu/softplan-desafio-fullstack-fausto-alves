package com.softplan.gestao.dto;

import java.io.Serializable;
import java.util.Date;

public class ParecerListDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer idParecer;

    private String numeroProcesso;

    private String tituloProcesso;

    private String nomeUsuario;
    
    private String textoParecer;
    
    private String decisaoParecer;
    
    private Date dataParecer;

	
    public ParecerListDTO() {
		super();
	}


	public ParecerListDTO(Integer idParecer, String numeroProcesso, String tituloProcesso, String nomeUsuario,
			String textoParecer, String decisaoParecer) {
		super();
		this.idParecer = idParecer;
		this.numeroProcesso = numeroProcesso;
		this.tituloProcesso = tituloProcesso;
		this.nomeUsuario = nomeUsuario;
		this.textoParecer = textoParecer;
		this.decisaoParecer = decisaoParecer;
	}


	public Integer getIdParecer() {
		return idParecer;
	}


	public void setIdParecer(Integer idParecer) {
		this.idParecer = idParecer;
	}


	public String getNumeroProcesso() {
		return numeroProcesso;
	}


	public void setNumeroProcesso(String numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}


	public String getTituloProcesso() {
		return tituloProcesso;
	}


	public void setTituloProcesso(String tituloProcesso) {
		this.tituloProcesso = tituloProcesso;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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


	public Date getDataParecer() {
		return dataParecer;
	}


	public void setDataParecer(Date dataParecer) {
		this.dataParecer = dataParecer;
	}
	
}
