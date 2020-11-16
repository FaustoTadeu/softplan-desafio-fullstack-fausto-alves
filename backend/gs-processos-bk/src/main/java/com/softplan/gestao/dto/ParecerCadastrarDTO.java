package com.softplan.gestao.dto;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class ParecerCadastrarDTO implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idParecer;

    @NotEmpty (message = "O texto do parecer é de preenchimento obrigatório")
    @Size (min=5, max=2000,  message = "O texto do parecer deve ter entre 5 e 2000 caracteres")
    private String textoParecer;

    @NotEmpty (message = "A decisão do parecer é de preenchimento obrigatório")
    private String decisaoParecer;

	
    public ParecerCadastrarDTO() {
		super();
	}


	public ParecerCadastrarDTO(Integer idParecer, String textoParecer, String decisaoParecer) {
		super();
		this.idParecer = idParecer;
		this.textoParecer = textoParecer;
		this.decisaoParecer = decisaoParecer;
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
}
