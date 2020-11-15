package com.softplan.gestao.dto;

import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ProcessosNewDTO  implements Serializable{

    private static final long serialVersionUID = 1L;

    private Integer idProcessos;

    @NotEmpty (message = "Preenchimento obrigatório")
    private String numeroProcessos;
    
    @NotEmpty (message = "Preenchimento obrigatório")
    @Size (min=5, max=200,  message = "O título do processo deve ter entre 5 e 200 caracteres")
    private String tituloProcessos;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Size (min=5, max=2000,  message = "O texto do processo deve ter entre 5 e 2000 caracteres")
    private String textoProcessos;

    @NotEmpty(message = "Preenchimento obrigatório")
    private Date dataProcessos;
    
    @NotEmpty(message = "Preenchimento obrigatório")
    private String statusProcessos;

	
    public ProcessosNewDTO() {
		super();
	}


	public ProcessosNewDTO(Integer idProcessos, String numeroProcessos, String tituloProcessos, String textoProcessos, Date dataProcessos, String statusProcessos) {
		super();
		this.idProcessos = idProcessos;
		this.numeroProcessos = numeroProcessos;
		this.tituloProcessos = tituloProcessos;
		this.textoProcessos = textoProcessos;
		this.dataProcessos = dataProcessos;
		this.statusProcessos = statusProcessos;
	}


	public Integer getIdProcessos() {
		return idProcessos;
	}


	public void setIdProcessos(Integer idProcessos) {
		this.idProcessos = idProcessos;
	}


	public String getNumeroProcessos() {
		return numeroProcessos;
	}


	public void setNumeroProcessos(String numeroProcessos) {
		this.numeroProcessos = numeroProcessos;
	}


	public String getTituloProcessos() {
		return tituloProcessos;
	}


	public void setTituloProcessos(String tituloProcessos) {
		this.tituloProcessos = tituloProcessos;
	}


	public String getTextoProcessos() {
		return textoProcessos;
	}


	public void setTextoProcessos(String textoProcessos) {
		this.textoProcessos = textoProcessos;
	}


	public Date getDataProcessos() {
		return dataProcessos;
	}


	public void setDataProcessos(Date dataProcessos) {
		this.dataProcessos = dataProcessos;
	}


	public String getStatusProcessos() {
		return statusProcessos;
	}


	public void setStatusProcessos(String statusProcessos) {
		this.statusProcessos = statusProcessos;
	}
    
    

   
    

}
