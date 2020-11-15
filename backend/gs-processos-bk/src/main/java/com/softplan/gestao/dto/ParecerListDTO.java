package com.softplan.gestao.dto;

import java.io.Serializable;
import java.util.Date;
import com.softplan.gestao.model.Processos;
import com.softplan.gestao.model.Usuarios;

public class ParecerListDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    private Integer idParecer;

    private String textoParecer;

    private String decisaoParecer;

    private Date dataParecer;
    
    private Usuarios usuarioParecer;
    
    private Processos processoParecer;

	
    public ParecerListDTO() {
		super();
	}


	public ParecerListDTO(Integer idParecer, String textoParecer, String decisaoParecer, Date dataParecer,
			Usuarios usuarioParecer, Processos processoParecer) {
		super();
		this.idParecer = idParecer;
		this.textoParecer = textoParecer;
		this.decisaoParecer = decisaoParecer;
		this.dataParecer = dataParecer;
		this.usuarioParecer = usuarioParecer;
		this.processoParecer = processoParecer;
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


	public Date getDataParecer() {
		return dataParecer;
	}


	public void setDataParecer(Date dataParecer) {
		this.dataParecer = dataParecer;
	}


	public Usuarios getUsuarioParecer () {
		return usuarioParecer;
	}


	public void setUsuarioParecer (Usuarios usuarioParecer) {
		this.usuarioParecer = usuarioParecer;
	}


	public Processos getProcessoParecer() {
		return processoParecer;
	}


	public void setProcessoParecer(Processos processoParecer) {
		this.processoParecer = processoParecer;
	}
}
