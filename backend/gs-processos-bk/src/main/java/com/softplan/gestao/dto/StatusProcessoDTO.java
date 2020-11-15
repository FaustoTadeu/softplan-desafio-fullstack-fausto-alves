package com.softplan.gestao.dto;

import java.io.Serializable;

public class StatusProcessoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idProcessos;
    private String checked;
	
    
    public StatusProcessoDTO() {
		super();
	}

	public StatusProcessoDTO(Integer idProcessos, String checked) {
		super();
		this.idProcessos = idProcessos;
		this.checked = checked;
	}
	
	

	public Integer getIdProcessos() {
		return idProcessos;
	}

	public void setIdProcessos(Integer idProcessos) {
		this.idProcessos = idProcessos;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}
}
