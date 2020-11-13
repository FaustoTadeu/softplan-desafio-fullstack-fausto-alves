package com.softplan.gestao.model;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softplan.gestao.enums.PerfilUsuario;

@Entity(name = "usuarios")
public class Usuarios implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuarios;

    private String nomeUsuarios;

    @Column(unique=true)
    private String emailUsuarios;

    @Column(unique=true)
    private String cpfUsuarios;

    private String statusUsuarios;

    private Date dataCadastro;

    @JsonIgnore
    private String senhaUsuarios;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="PERFIL")
    private Set<Integer> perfis = new HashSet<>();
    
    @JsonIgnore
    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
    private List<Parecer> parecerList = new ArrayList<>();
    
    
    
    /* --- Construtores --- */

    public Usuarios(Integer idUsuarios, String cpfUsuarios, String nomeUsuarios, String emailUsuarios, String senhaUsuarios,   Set<Integer> perfis) {
        this.idUsuarios = idUsuarios;
        this.cpfUsuarios = cpfUsuarios;
        this.nomeUsuarios = nomeUsuarios;
        this.emailUsuarios = emailUsuarios;
        this.senhaUsuarios = senhaUsuarios;
        this.perfis = perfis;
    }

    public Usuarios (Integer idUsuarios, String nomeUsuarios, String emailUsuarios) {
        this.idUsuarios = idUsuarios;
        this.nomeUsuarios = nomeUsuarios;
        this.emailUsuarios = emailUsuarios;
    }

    public Usuarios(Integer idUsuarios, String nomeUsuarios, String emailUsuarios, String cpfUsuarios, String statusUsuarios, Date dataCadastro, String senhaUsuarios, Set<Integer> perfis) {
        this.idUsuarios = idUsuarios;
        this.nomeUsuarios = nomeUsuarios;
        this.emailUsuarios = emailUsuarios;
        this.cpfUsuarios = cpfUsuarios;
        this.statusUsuarios = statusUsuarios;
        this.dataCadastro = dataCadastro;
        this.senhaUsuarios = senhaUsuarios;
        this.perfis = perfis;
    }


	/* --- GETs e SETs --- */

	public Integer getIdUsuarios() {
		return idUsuarios;
	}

	public void setIdUsuarios(Integer idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getNomeUsuarios() {
		return nomeUsuarios;
	}

	public void setNomeUsuarios(String nomeUsuarios) {
		this.nomeUsuarios = nomeUsuarios;
	}

	public String getEmailUsuarios() {
		return emailUsuarios;
	}

	public void setEmailUsuarios(String emailUsuarios) {
		this.emailUsuarios = emailUsuarios;
	}

	public String getCpfUsuarios() {
		return cpfUsuarios;
	}

	public void setCpfUsuarios(String cpfUsuarios) {
		this.cpfUsuarios = cpfUsuarios;
	}

	public String getStatusUsuarios() {
		return statusUsuarios;
	}

	public void setStatusUsuarios(String statusUsuarios) {
		this.statusUsuarios = statusUsuarios;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getSenhaUsuarios() {
		return senhaUsuarios;
	}

	public void setSenhaUsuarios(String senhaUsuarios) {
		this.senhaUsuarios = senhaUsuarios;
	}
	
	public Set<PerfilUsuario> getPerfis () { 
	    return perfis.stream().map(x -> PerfilUsuario.toEnum(x)).collect(Collectors.toSet());
	}

	 public void setPerfil(PerfilUsuario perfil) {
	    perfis.add(perfil.getCod());
	 }

	public List<Parecer> getParecerList() {
		return parecerList;
	}

	public void setParecerList(List<Parecer> parecerList) {
		this.parecerList = parecerList;
	}
	 
	 
}
