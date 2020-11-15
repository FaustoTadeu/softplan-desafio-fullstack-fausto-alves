package com.softplan.gestao.dto;

public class ProcessoRetornoDTO {
	
	private String numeroProcesso;
	private String tituloProcesso;
	
	
	public ProcessoRetornoDTO() {
		super();
	}
	
	public ProcessoRetornoDTO(String numeroProcesso, String tituloProcesso) {
		super();
		this.numeroProcesso = numeroProcesso;
		this.tituloProcesso = tituloProcesso;
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
}
