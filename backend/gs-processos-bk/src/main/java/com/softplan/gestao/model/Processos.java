package com.softplan.gestao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "processos")
public class Processos implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcessos;

    private String numeroProcessos;

    private String tituloProcessos;

    private String textoProcessos;

    private Date dtCadastroProcessos;
    
    private String statusProcessos;
    
    @JsonIgnore
    @OneToMany(mappedBy="processo", cascade = CascadeType.ALL)
    private List<Parecer> parecerList = new ArrayList<>();

	
    /* --- Constructors --  */
    
    public Processos() {
		super();
	}

	public Processos(Integer idProcessos, String numeroProcessos, String tituloProcessos, String textoProcessos,
			Date dtCadastroProcessos, String statusProcessos) {
		super();
		this.idProcessos = idProcessos;
		this.numeroProcessos = numeroProcessos;
		this.tituloProcessos = tituloProcessos;
		this.textoProcessos = textoProcessos;
		this.dtCadastroProcessos = dtCadastroProcessos;
		this.statusProcessos = statusProcessos;
	}

	
	/* --- Getters and Setters --  */
	
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

	public Date getDtCadastroProcessos() {
		return dtCadastroProcessos;
	}

	public void setDtCadastroProcessos(Date dtCadastroProcessos) {
		this.dtCadastroProcessos = dtCadastroProcessos;
	}
	
	public String getStatusProcessos() {
		return statusProcessos;
	}

	public void setStatusProcessos(String statusProcessos) {
		this.statusProcessos = statusProcessos;
	}

	public List<Parecer> getParecerList() {
		return parecerList;
	}

	public void setParecerList(List<Parecer> parecerList) {
		this.parecerList = parecerList;
	}
	
	
	
}
