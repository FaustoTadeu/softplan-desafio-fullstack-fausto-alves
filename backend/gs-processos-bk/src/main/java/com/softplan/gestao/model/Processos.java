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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "processos")
public class Processos implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProcessos;

    @NotEmpty (message = "O número do processo é de preenchimento obrigatório")
    @Size (min=5, max=200,  message = "O numero do processo deve ter entre 5 e 200 caracteres")
    private String numeroProcessos;

    @NotEmpty (message = "O título do processo é de preenchimento obrigatório")
    @Size (min=5, max=200,  message = "O título do processo deve ter entre 5 e 200 caracteres")
    private String tituloProcessos;

    @NotEmpty (message = "O texto do processo é de preenchimento obrigatório")
    @Size (min=5, max=2000,  message = "O texto do processo deve ter entre 5 e 2000 caracteres")
    private String textoProcessos;

    @NotEmpty (message = "A data de cadastro do processo é de preenchimento obrigatório")
    private Date dtCadastroProcessos;
    
    @JsonIgnore
    @OneToMany(mappedBy="processo", cascade = CascadeType.ALL)
    private List<Parecer> parecerList = new ArrayList<>();

	
    /* --- Constructors --  */
    
    public Processos() {
		super();
	}

	public Processos(Integer idProcessos, String numeroProcessos, String tituloProcessos, String textoProcessos,
			Date dtCadastroProcessos) {
		super();
		this.idProcessos = idProcessos;
		this.numeroProcessos = numeroProcessos;
		this.tituloProcessos = tituloProcessos;
		this.textoProcessos = textoProcessos;
		this.dtCadastroProcessos = dtCadastroProcessos;
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

	public List<Parecer> getParecerList() {
		return parecerList;
	}

	public void setParecerList(List<Parecer> parecerList) {
		this.parecerList = parecerList;
	}
	
}
