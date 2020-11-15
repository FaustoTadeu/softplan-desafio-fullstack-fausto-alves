package com.softplan.gestao.dto;

import java.io.Serializable;
import java.util.Date;

import com.softplan.gestao.model.Processos;

public class ProcessosListDTO implements Serializable {

	    private static final long serialVersionUID = 1L;

	    private Integer idProcessos;
	    
	    private String numeroProcessos;

	    private String tituloProcessos;

	    private String textoProcessos;

	    private Date dataProcessos;

	    private String statusProcessos;
	    
	    private Integer atribuicoesProcessos;

		
	    public ProcessosListDTO() {
			super();
		}
	    
	    public ProcessosListDTO(Processos processo) {
			super();
			this.idProcessos = processo.getIdProcessos();
			this.numeroProcessos = processo.getNumeroProcessos();
			this.tituloProcessos = processo.getTituloProcessos();
			this.textoProcessos = processo.getTextoProcessos();
			this.dataProcessos = processo.getDtCadastroProcessos();
			this.statusProcessos = processo.getStatusProcessos();
			this.atribuicoesProcessos = processo.getParecerList().size();
		}

		public ProcessosListDTO(Integer idProcessos, String numeroProcessos, String tituloProcessos,
				String textoProcessos, Date dataProcessos, String statusProcessos) {
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

		public Integer getAtribuicoesProcessos() {
			return atribuicoesProcessos;
		}

		public void setAtribuicoesProcessos(Integer atribuicoesProcessos) {
			this.atribuicoesProcessos = atribuicoesProcessos;
		}
		
}
